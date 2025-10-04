package com.jarvisai.assistant.core.asr

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.vosk.LibVosk
import org.vosk.LogLevel
import org.vosk.Model
import org.vosk.Recognizer
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

data class ASRResult(
    val text: String,
    val confidence: Float,
    val isFinal: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

sealed class ASRState {
    object Initializing : ASRState()
    object Ready : ASRState()
    object Listening : ASRState()
    object Processing : ASRState()
    data class Error(val message: String) : ASRState()
}

interface ASREngine {
    val state: Flow<ASRState>
    val results: Flow<ASRResult>
    
    suspend fun initialize(): Boolean
    suspend fun startListening()
    suspend fun stopListening()
    suspend fun processAudioData(audioData: ShortArray): ASRResult?
    fun release()
}

@Singleton
class VoskASR @Inject constructor(
    private val context: Context
) : ASREngine {
    
    private val TAG = "VoskASR"
    private val SAMPLE_RATE = 16000
    
    private var model: Model? = null
    private var recognizer: Recognizer? = null
    
    private val _state = MutableStateFlow<ASRState>(ASRState.Initializing)
    override val state: Flow<ASRState> = _state.asStateFlow()
    
    private val _results = MutableStateFlow<ASRResult?>(null)
    override val results: Flow<ASRResult> = _results.asStateFlow().filterNotNull()
    
    private var isListening = false
    private var audioBuffer = mutableListOf<Short>()
    
    companion object {
        // Model files to be placed in assets/vosk-models/
        const val MODEL_NAME = "vosk-model-small-en-us-0.15"
        const val MODEL_ASSET_PATH = "vosk-models/$MODEL_NAME"
    }
    
    override suspend fun initialize(): Boolean = withContext(Dispatchers.IO) {
        try {
            _state.value = ASRState.Initializing
            
            // Initialize Vosk logging
            LibVosk.setLogLevel(LogLevel.WARNINGS)
            
            // Extract model from assets if needed
            val modelDir = extractModelFromAssets()
            if (modelDir == null) {
                _state.value = ASRState.Error("Failed to extract model from assets")
                return@withContext false
            }
            
            // Initialize model
            model = Model(modelDir.absolutePath)
            recognizer = Recognizer(model, SAMPLE_RATE.toFloat())
            
            _state.value = ASRState.Ready
            Log.d(TAG, "Vosk ASR initialized successfully")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initialize Vosk ASR", e)
            _state.value = ASRState.Error("Initialization failed: ${e.message}")
            false
        }
    }
    
    private suspend fun extractModelFromAssets(): File? = withContext(Dispatchers.IO) {
        try {
            val modelDir = File(context.filesDir, MODEL_NAME)
            
            // Check if model already exists
            if (modelDir.exists() && modelDir.isDirectory && modelDir.listFiles()?.isNotEmpty() == true) {
                Log.d(TAG, "Model already exists at ${modelDir.absolutePath}")
                return@withContext modelDir
            }
            
            // Create model directory
            if (!modelDir.exists()) {
                modelDir.mkdirs()
            }
            
            // Extract model files from assets
            val assetManager = context.assets
            extractAssetFolder(assetManager, MODEL_ASSET_PATH, modelDir)
            
            if (modelDir.listFiles()?.isNotEmpty() == true) {
                Log.d(TAG, "Model extracted to ${modelDir.absolutePath}")
                modelDir
            } else {
                Log.e(TAG, "Failed to extract model - directory is empty")
                null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error extracting model from assets", e)
            null
        }
    }
    
    private fun extractAssetFolder(assetManager: AssetManager, fromAssetPath: String, toDir: File) {
        try {
            val files = assetManager.list(fromAssetPath) ?: return
            
            for (filename in files) {
                val assetPath = "$fromAssetPath/$filename"
                val destFile = File(toDir, filename)
                
                try {
                    val subFiles = assetManager.list(assetPath)
                    if (subFiles != null && subFiles.isNotEmpty()) {
                        // It's a directory
                        if (!destFile.exists()) {
                            destFile.mkdirs()
                        }
                        extractAssetFolder(assetManager, assetPath, destFile)
                    } else {
                        // It's a file
                        extractAssetFile(assetManager, assetPath, destFile)
                    }
                } catch (e: IOException) {
                    // Treat as file if listing fails
                    extractAssetFile(assetManager, assetPath, destFile)
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "Error extracting asset folder: $fromAssetPath", e)
        }
    }
    
    private fun extractAssetFile(assetManager: AssetManager, assetPath: String, destFile: File) {
        try {
            assetManager.open(assetPath).use { inputStream ->
                FileOutputStream(destFile).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            Log.d(TAG, "Extracted file: ${destFile.name}")
        } catch (e: IOException) {
            Log.e(TAG, "Error extracting asset file: $assetPath", e)
        }
    }
    
    override suspend fun startListening() {
        if (recognizer == null) {
            Log.w(TAG, "ASR not initialized")
            return
        }
        
        try {
            recognizer?.reset()
            isListening = true
            audioBuffer.clear()
            _state.value = ASRState.Listening
            Log.d(TAG, "Started listening")
        } catch (e: Exception) {
            Log.e(TAG, "Error starting listening", e)
            _state.value = ASRState.Error("Failed to start listening: ${e.message}")
        }
    }
    
    override suspend fun stopListening() {
        isListening = false
        
        try {
            // Process any remaining audio data
            if (audioBuffer.isNotEmpty()) {
                processFinalAudio()
            }
            
            _state.value = ASRState.Ready
            Log.d(TAG, "Stopped listening")
        } catch (e: Exception) {
            Log.e(TAG, "Error stopping listening", e)
            _state.value = ASRState.Error("Failed to stop listening: ${e.message}")
        }
    }
    
    override suspend fun processAudioData(audioData: ShortArray): ASRResult? = withContext(Dispatchers.IO) {
        if (!isListening || recognizer == null) {
            return@withContext null
        }
        
        try {
            _state.value = ASRState.Processing
            
            // Convert ShortArray to ByteArray for Vosk
            val byteArray = ByteArray(audioData.size * 2)
            for (i in audioData.indices) {
                val value = audioData[i].toInt()
                byteArray[i * 2] = (value and 0xFF).toByte()
                byteArray[i * 2 + 1] = ((value shr 8) and 0xFF).toByte()
            }
            
            // Process with Vosk
            val result = if (recognizer!!.acceptWaveForm(byteArray, byteArray.size)) {
                // Final result
                val resultJson = recognizer!!.result
                parseResult(resultJson, isFinal = true)
            } else {
                // Partial result
                val partialJson = recognizer!!.partialResult
                parseResult(partialJson, isFinal = false)
            }
            
            _state.value = ASRState.Listening
            
            result?.let { _results.value = it }
            result
        } catch (e: Exception) {
            Log.e(TAG, "Error processing audio data", e)
            _state.value = ASRState.Error("Processing failed: ${e.message}")
            null
        }
    }
    
    private suspend fun processFinalAudio() = withContext(Dispatchers.IO) {
        try {
            recognizer?.let { rec ->
                val finalResult = rec.finalResult
                val result = parseResult(finalResult, isFinal = true)
                result?.let { _results.value = it }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error processing final audio", e)
        }
    }
    
    private fun parseResult(jsonResult: String, isFinal: Boolean): ASRResult? {
        return try {
            val jsonObject = JSONObject(jsonResult)
            val text = jsonObject.optString("text", "").trim()
            
            if (text.isEmpty()) {
                return null
            }
            
            // Vosk doesn't provide confidence directly in the basic result
            // For confidence, you'd need to parse the alternatives array if available
            val confidence = jsonObject.optDouble("confidence", 0.8).toFloat()
            
            ASRResult(
                text = text,
                confidence = confidence,
                isFinal = isFinal
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing ASR result", e)
            null
        }
    }
    
    override fun release() {
        try {
            isListening = false
            recognizer?.close()
            model?.close()
            recognizer = null
            model = null
            _state.value = ASRState.Initializing
            Log.d(TAG, "Vosk ASR released")
        } catch (e: Exception) {
            Log.e(TAG, "Error releasing Vosk ASR", e)
        }
    }
    
    // Utility methods
    fun isModelAvailable(): Boolean {
        val modelDir = File(context.filesDir, MODEL_NAME)
        return modelDir.exists() && modelDir.isDirectory
    }
    
    suspend fun downloadModel(): Boolean {
        // This would implement model downloading from a server
        // For now, models should be included in assets
        return false
    }
    
    fun getModelInfo(): String {
        return "Model: $MODEL_NAME (16kHz, English)"
    }
}
