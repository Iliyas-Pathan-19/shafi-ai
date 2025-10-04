package com.jarvisai.assistant.core.tts

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.speech.tts.Voice
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume

data class TTSVoice(
    val id: String,
    val name: String,
    val language: String,
    val quality: VoiceQuality,
    val isCloned: Boolean = false,
    val clonePath: String? = null
)

enum class VoiceQuality {
    LOW, NORMAL, HIGH, VERY_HIGH
}

sealed class TTSState {
    object Initializing : TTSState()
    object Ready : TTSState()
    object Speaking : TTSState()
    object Paused : TTSState()
    data class Error(val message: String) : TTSState()
}

data class TTSRequest(
    val text: String,
    val voice: TTSVoice,
    val pitch: Float = 1.0f,
    val speed: Float = 1.0f,
    val emotion: String? = null,
    val utteranceId: String = UUID.randomUUID().toString()
)

interface TTSEngine {
    val state: Flow<TTSState>
    val availableVoices: Flow<List<TTSVoice>>
    
    suspend fun initialize(): Boolean
    suspend fun speak(request: TTSRequest): Boolean
    suspend fun stop()
    suspend fun pause()
    suspend fun resume()
    fun release()
    
    // Voice cloning
    suspend fun createVoiceClone(name: String, audioSamples: List<File>): TTSVoice?
    suspend fun deleteVoiceClone(voiceId: String): Boolean
    fun getClonedVoices(): List<TTSVoice>
}

@Singleton
class JarvisTTS @Inject constructor(
    private val context: Context
) : TTSEngine {
    
    private val TAG = "JarvisTTS"
    
    private var textToSpeech: TextToSpeech? = null
    private var audioTrack: AudioTrack? = null
    
    private val _state = MutableStateFlow<TTSState>(TTSState.Initializing)
    override val state: Flow<TTSState> = _state.asStateFlow()
    
    private val _availableVoices = MutableStateFlow<List<TTSVoice>>(emptyList())
    override val availableVoices: Flow<List<TTSVoice>> = _availableVoices.asStateFlow()
    
    private val voiceCloneDir = File(context.filesDir, "voice_clones")
    private var isInitialized = false
    
    override suspend fun initialize(): Boolean = suspendCancellableCoroutine { continuation ->
        _state.value = TTSState.Initializing
        
        textToSpeech = TextToSpeech(context) { status ->
            when (status) {
                TextToSpeech.SUCCESS -> {
                    try {
                        setupTTS()
                        loadAvailableVoices()
                        isInitialized = true
                        _state.value = TTSState.Ready
                        Log.d(TAG, "TTS initialized successfully")
                        continuation.resume(true)
                    } catch (e: Exception) {
                        Log.e(TAG, "Error setting up TTS", e)
                        _state.value = TTSState.Error("Setup failed: ${e.message}")
                        continuation.resume(false)
                    }
                }
                else -> {
                    Log.e(TAG, "TTS initialization failed with status: $status")
                    _state.value = TTSState.Error("TTS initialization failed")
                    continuation.resume(false)
                }
            }
        }
        
        // Setup voice clone directory
        if (!voiceCloneDir.exists()) {
            voiceCloneDir.mkdirs()
        }
    }
    
    private fun setupTTS() {
        textToSpeech?.let { tts ->
            // Set default language
            val langResult = tts.setLanguage(Locale.US)
            if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.w(TAG, "Language not supported, using default")
            }
            
            // Set up utterance progress listener
            tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _state.value = TTSState.Speaking
                    Log.d(TAG, "Started speaking: $utteranceId")
                }
                
                override fun onDone(utteranceId: String?) {
                    _state.value = TTSState.Ready
                    Log.d(TAG, "Finished speaking: $utteranceId")
                }
                
                override fun onError(utteranceId: String?) {
                    _state.value = TTSState.Error("Speech error for utterance: $utteranceId")
                    Log.e(TAG, "Speech error: $utteranceId")
                }
                
                override fun onStop(utteranceId: String?, interrupted: Boolean) {
                    _state.value = TTSState.Ready
                    Log.d(TAG, "Speech stopped: $utteranceId, interrupted: $interrupted")
                }
                
                override fun onRangeStart(utteranceId: String?, start: Int, end: Int, frame: Int) {
                    // Optional: track speech progress
                }
            })
        }
    }
    
    private fun loadAvailableVoices() {
        val voices = mutableListOf<TTSVoice>()
        
        textToSpeech?.let { tts ->
            // Add system voices
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts.voices?.forEach { voice ->
                    val quality = when {
                        voice.quality >= Voice.QUALITY_VERY_HIGH -> VoiceQuality.VERY_HIGH
                        voice.quality >= Voice.QUALITY_HIGH -> VoiceQuality.HIGH
                        voice.quality >= Voice.QUALITY_NORMAL -> VoiceQuality.NORMAL
                        else -> VoiceQuality.LOW
                    }
                    
                    voices.add(
                        TTSVoice(
                            id = voice.name,
                            name = voice.name,
                            language = voice.locale.displayLanguage,
                            quality = quality
                        )
                    )
                }
            } else {
                // Fallback for older Android versions
                voices.add(
                    TTSVoice(
                        id = "default",
                        name = "Default Voice",
                        language = "English",
                        quality = VoiceQuality.NORMAL
                    )
                )
            }
            
            // Add cloned voices
            voices.addAll(getClonedVoices())
        }
        
        _availableVoices.value = voices
        Log.d(TAG, "Loaded ${voices.size} voices")
    }
    
    override suspend fun speak(request: TTSRequest): Boolean = withContext(Dispatchers.Main) {
        if (!isInitialized || textToSpeech == null) {
            Log.w(TAG, "TTS not initialized")
            return@withContext false
        }
        
        try {
            val tts = textToSpeech!!
            
            // Set voice if available (Android 5.0+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !request.voice.isCloned) {
                val systemVoice = tts.voices?.find { it.name == request.voice.id }
                systemVoice?.let { tts.voice = it }
            }
            
            // Set speech parameters
            tts.setPitch(request.pitch)
            tts.setSpeechRate(request.speed)
            
            // Handle cloned voice
            if (request.voice.isCloned) {
                return@withContext speakWithClonedVoice(request)
            }
            
            // Create parameters bundle
            val params = Bundle().apply {
                putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, request.utteranceId)
                
                // Add emotion-based adjustments
                request.emotion?.let { emotion ->
                    val (pitch, speed) = getEmotionParameters(emotion)
                    tts.setPitch(request.pitch * pitch)
                    tts.setSpeechRate(request.speed * speed)
                }
            }
            
            // Speak the text
            val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts.speak(request.text, TextToSpeech.QUEUE_FLUSH, params, request.utteranceId)
            } else {
                @Suppress("DEPRECATION")
                tts.speak(request.text, TextToSpeech.QUEUE_FLUSH, params.toHashMap())
            }
            
            val success = result == TextToSpeech.SUCCESS
            if (!success) {
                Log.e(TAG, "TTS speak failed with result: $result")
                _state.value = TTSState.Error("Speech failed")
            }
            
            success
        } catch (e: Exception) {
            Log.e(TAG, "Error during speech", e)
            _state.value = TTSState.Error("Speech error: ${e.message}")
            false
        }
    }
    
    private fun Bundle.toHashMap(): HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        for (key in keySet()) {
            val value = get(key)
            if (value is String) {
                hashMap[key] = value
            }
        }
        return hashMap
    }
    
    private fun getEmotionParameters(emotion: String): Pair<Float, Float> {
        return when (emotion.lowercase()) {
            "happy", "excited" -> Pair(1.2f, 1.1f) // Higher pitch, faster
            "sad", "disappointed" -> Pair(0.8f, 0.9f) // Lower pitch, slower
            "angry", "frustrated" -> Pair(1.1f, 1.2f) // Slightly higher pitch, faster
            "surprised" -> Pair(1.3f, 1.0f) // Higher pitch, normal speed
            "calm", "neutral" -> Pair(1.0f, 1.0f) // Normal
            else -> Pair(1.0f, 1.0f)
        }
    }
    
    private suspend fun speakWithClonedVoice(request: TTSRequest): Boolean = withContext(Dispatchers.IO) {
        // This is a placeholder for voice cloning implementation
        // In a real implementation, this would:
        // 1. Load the cloned voice model
        // 2. Generate audio using the model
        // 3. Play the generated audio
        
        request.voice.clonePath?.let { clonePath ->
            val voiceFile = File(clonePath)
            if (voiceFile.exists()) {
                Log.d(TAG, "Would use cloned voice: ${request.voice.name}")
                // For now, fallback to regular TTS
                return@withContext speakWithSystemVoice(request)
            }
        }
        
        false
    }
    
    private suspend fun speakWithSystemVoice(request: TTSRequest): Boolean = withContext(Dispatchers.Main) {
        textToSpeech?.let { tts ->
            val result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts.speak(request.text, TextToSpeech.QUEUE_FLUSH, Bundle(), request.utteranceId)
            } else {
                @Suppress("DEPRECATION")
                tts.speak(request.text, TextToSpeech.QUEUE_FLUSH, null)
            }
            return@withContext result == TextToSpeech.SUCCESS
        }
        false
    }
    
    override suspend fun stop() {
        textToSpeech?.stop()
        audioTrack?.stop()
        _state.value = TTSState.Ready
    }
    
    override suspend fun pause() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textToSpeech?.stop()
        }
        audioTrack?.pause()
        _state.value = TTSState.Paused
    }
    
    override suspend fun resume() {
        audioTrack?.play()
        _state.value = TTSState.Speaking
    }
    
    override fun release() {
        try {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
            textToSpeech = null
            
            audioTrack?.stop()
            audioTrack?.release()
            audioTrack = null
            
            isInitialized = false
            _state.value = TTSState.Initializing
            Log.d(TAG, "TTS released")
        } catch (e: Exception) {
            Log.e(TAG, "Error releasing TTS", e)
        }
    }
    
    // Voice Cloning Implementation
    override suspend fun createVoiceClone(name: String, audioSamples: List<File>): TTSVoice? = withContext(Dispatchers.IO) {
        try {
            val voiceId = "clone_${name.lowercase().replace(" ", "_")}_${System.currentTimeMillis()}"
            val voiceDir = File(voiceCloneDir, voiceId)
            
            if (!voiceDir.exists()) {
                voiceDir.mkdirs()
            }
            
            // Copy audio samples to voice directory
            val sampleFiles = mutableListOf<File>()
            audioSamples.forEachIndexed { index, sampleFile ->
                val destFile = File(voiceDir, "sample_$index.wav")
                sampleFile.copyTo(destFile, overwrite = true)
                sampleFiles.add(destFile)
            }
            
            // Create voice metadata
            val metadataFile = File(voiceDir, "metadata.json")
            val metadata = createVoiceMetadata(name, sampleFiles)
            metadataFile.writeText(metadata)
            
            // In a real implementation, this would:
            // 1. Process audio samples to extract voice characteristics
            // 2. Train or configure a voice model
            // 3. Save the model for later use
            
            val clonedVoice = TTSVoice(
                id = voiceId,
                name = name,
                language = "English", // Detected from samples
                quality = VoiceQuality.HIGH,
                isCloned = true,
                clonePath = voiceDir.absolutePath
            )
            
            // Update available voices
            val currentVoices = _availableVoices.value.toMutableList()
            currentVoices.add(clonedVoice)
            _availableVoices.value = currentVoices
            
            Log.d(TAG, "Created voice clone: $name")
            clonedVoice
        } catch (e: Exception) {
            Log.e(TAG, "Error creating voice clone", e)
            null
        }
    }
    
    private fun createVoiceMetadata(name: String, sampleFiles: List<File>): String {
        return """
        {
            "name": "$name",
            "created": ${System.currentTimeMillis()},
            "samples": [
                ${sampleFiles.joinToString(",") { "\"${it.name}\"" }}
            ],
            "language": "en",
            "version": "1.0"
        }
        """.trimIndent()
    }
    
    override suspend fun deleteVoiceClone(voiceId: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val voiceDir = File(voiceCloneDir, voiceId)
            if (voiceDir.exists()) {
                voiceDir.deleteRecursively()
                
                // Update available voices
                val currentVoices = _availableVoices.value.toMutableList()
                currentVoices.removeAll { it.id == voiceId }
                _availableVoices.value = currentVoices
                
                Log.d(TAG, "Deleted voice clone: $voiceId")
                true
            } else {
                false
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error deleting voice clone", e)
            false
        }
    }
    
    override fun getClonedVoices(): List<TTSVoice> {
        val clonedVoices = mutableListOf<TTSVoice>()
        
        try {
            if (voiceCloneDir.exists()) {
                voiceCloneDir.listFiles()?.forEach { voiceDir ->
                    if (voiceDir.isDirectory) {
                        val metadataFile = File(voiceDir, "metadata.json")
                        if (metadataFile.exists()) {
                            try {
                                val metadata = metadataFile.readText()
                                val name = extractNameFromMetadata(metadata)
                                
                                clonedVoices.add(
                                    TTSVoice(
                                        id = voiceDir.name,
                                        name = name ?: voiceDir.name,
                                        language = "English",
                                        quality = VoiceQuality.HIGH,
                                        isCloned = true,
                                        clonePath = voiceDir.absolutePath
                                    )
                                )
                            } catch (e: Exception) {
                                Log.w(TAG, "Error reading voice metadata: ${voiceDir.name}", e)
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error loading cloned voices", e)
        }
        
        return clonedVoices
    }
    
    private fun extractNameFromMetadata(metadata: String): String? {
        return try {
            // Simple JSON parsing for name field
            val nameRegex = "\"name\"\\s*:\\s*\"([^\"]+)\"".toRegex()
            nameRegex.find(metadata)?.groupValues?.get(1)
        } catch (e: Exception) {
            null
        }
    }
    
    // Utility methods
    fun getCurrentVoice(): TTSVoice? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech?.voice?.let { voice ->
                TTSVoice(
                    id = voice.name,
                    name = voice.name,
                    language = voice.locale.displayLanguage,
                    quality = when {
                        voice.quality >= Voice.QUALITY_VERY_HIGH -> VoiceQuality.VERY_HIGH
                        voice.quality >= Voice.QUALITY_HIGH -> VoiceQuality.HIGH
                        voice.quality >= Voice.QUALITY_NORMAL -> VoiceQuality.NORMAL
                        else -> VoiceQuality.LOW
                    }
                )
            }
        } else {
            null
        }
    }
    
    fun isSpeaking(): Boolean {
        return textToSpeech?.isSpeaking == true
    }
    
    fun getEngineInfo(): String {
        return textToSpeech?.defaultEngine ?: "Unknown"
    }
}
