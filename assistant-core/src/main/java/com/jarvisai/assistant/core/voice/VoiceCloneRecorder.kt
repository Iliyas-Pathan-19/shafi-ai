package com.jarvisai.assistant.core.voice

import android.content.Context
import android.content.pm.PackageManager
import android.Manifest
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.math.abs
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.inject.Inject
import javax.inject.Singleton

data class VoiceCloneSession(
    val sessionId: String,
    val targetSentences: List<String>,
    val recordedSamples: MutableList<File> = mutableListOf(),
    val currentSentenceIndex: Int = 0,
    val isComplete: Boolean = false
)

sealed class RecordingState {
    object Idle : RecordingState()
    object Preparing : RecordingState()
    object Recording : RecordingState()
    object Processing : RecordingState()
    data class Error(val message: String) : RecordingState()
}

data class AudioQualityMetrics(
    val duration: Long, // in milliseconds
    val averageAmplitude: Float,
    val signalToNoiseRatio: Float,
    val isGoodQuality: Boolean
)

@Singleton
class VoiceCloneRecorder @Inject constructor(
    private val context: Context
) {
    
    private val TAG = "VoiceCloneRecorder"
    
    // Audio configuration
    private val SAMPLE_RATE = 22050 // Higher quality for voice cloning
    private val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
    private val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
    private val BUFFER_SIZE = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNEL_CONFIG, AUDIO_FORMAT) * 2
    
    private var audioRecord: AudioRecord? = null
    private val _recordingState = MutableStateFlow<RecordingState>(RecordingState.Idle)
    val recordingState: Flow<RecordingState> = _recordingState.asStateFlow()
    
    private val _currentSession = MutableStateFlow<VoiceCloneSession?>(null)
    val currentSession: Flow<VoiceCloneSession?> = _currentSession.asStateFlow()
    
    private val voiceCloneDir = File(context.filesDir, "voice_cloning")
    
    // Predefined sentences for voice cloning training
    private val trainingPrompts = listOf(
        "Hello, my name is Jarvis and I'm your personal assistant.",
        "I can help you with calls, messages, navigation, and many other tasks.",
        "What would you like me to help you with today?",
        "I understand your request and I'll take care of it right away.",
        "Is there anything else I can help you with?",
        "I'm here to make your life easier and more convenient.",
        "Thank you for using my services. Have a wonderful day!",
        "I apologize, but I didn't quite understand that. Could you please repeat?",
        "Your privacy and security are my top priorities.",
        "I'm continuously learning to serve you better."
    )
    
    init {
        if (!voiceCloneDir.exists()) {
            voiceCloneDir.mkdirs()
        }
    }
    
    suspend fun startVoiceCloneSession(userName: String): VoiceCloneSession? = withContext(Dispatchers.IO) {
        try {
            val sessionId = "voice_clone_${userName.lowercase().replace(" ", "_")}_${System.currentTimeMillis()}"
            val sessionDir = File(voiceCloneDir, sessionId)
            
            if (!sessionDir.exists()) {
                sessionDir.mkdirs()
            }
            
            val session = VoiceCloneSession(
                sessionId = sessionId,
                targetSentences = trainingPrompts.shuffled().take(5) // Use 5 random prompts
            )
            
            _currentSession.value = session
            Log.d(TAG, "Started voice clone session: $sessionId")
            session
        } catch (e: Exception) {
            Log.e(TAG, "Error starting voice clone session", e)
            _recordingState.value = RecordingState.Error("Failed to start session: ${e.message}")
            null
        }
    }
    
    suspend fun startRecording(): Boolean = withContext(Dispatchers.Main) {
        val session = _currentSession.value ?: return@withContext false
        
        if (session.currentSentenceIndex >= session.targetSentences.size) {
            Log.w(TAG, "All sentences already recorded")
            return@withContext false
        }
        
        try {
            _recordingState.value = RecordingState.Preparing
            
            // Check microphone permission at runtime
            val hasMicPermission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
            if (!hasMicPermission) {
                Log.e(TAG, "RECORD_AUDIO permission not granted")
                _recordingState.value = RecordingState.Error("Microphone permission not granted. Please enable it in settings.")
                return@withContext false
            }

            // Initialize AudioRecord
            audioRecord = AudioRecord(
                MediaRecorder.AudioSource.MIC,
                SAMPLE_RATE,
                CHANNEL_CONFIG,
                AUDIO_FORMAT,
                BUFFER_SIZE
            )
            
            if (audioRecord?.state != AudioRecord.STATE_INITIALIZED) {
                Log.e(TAG, "AudioRecord initialization failed")
                _recordingState.value = RecordingState.Error("Failed to initialize audio recording")
                return@withContext false
            }
            
            // Attempt to start recording safely
            try {
                audioRecord?.startRecording()
            } catch (se: SecurityException) {
                Log.e(TAG, "Missing RECORD_AUDIO permission or permission denied", se)
                _recordingState.value = RecordingState.Error("Microphone permission required. Please grant RECORD_AUDIO.")
                return@withContext false
            }
            _recordingState.value = RecordingState.Recording
            
            Log.d(TAG, "Started recording sentence ${session.currentSentenceIndex + 1}/${session.targetSentences.size}")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error starting recording", e)
            _recordingState.value = RecordingState.Error("Recording failed: ${e.message}")
            false
        }
    }
    
    suspend fun stopRecording(): File? = withContext(Dispatchers.IO) {
        val session = _currentSession.value ?: return@withContext null
        
        try {
            _recordingState.value = RecordingState.Processing
            
            audioRecord?.stop()
            
            // Save the recorded audio
            val outputFile = File(
                File(voiceCloneDir, session.sessionId),
                "sample_${session.currentSentenceIndex}.wav"
            )
            
            val audioData = readAudioData()
            if (audioData.isNotEmpty()) {
                saveAsWav(audioData, outputFile)
                
                // Analyze audio quality
                val quality = analyzeAudioQuality(audioData)
                Log.d(TAG, "Audio quality: $quality")
                
                if (quality.isGoodQuality) {
                    // Update session
                    val updatedSamples = session.recordedSamples.toMutableList()
                    updatedSamples.add(outputFile)
                    
                    val updatedSession = session.copy(
                        recordedSamples = updatedSamples,
                        currentSentenceIndex = session.currentSentenceIndex + 1,
                        isComplete = session.currentSentenceIndex + 1 >= session.targetSentences.size
                    )
                    
                    _currentSession.value = updatedSession
                    _recordingState.value = RecordingState.Idle
                    
                    Log.d(TAG, "Saved audio sample: ${outputFile.name}")
                    return@withContext outputFile
                } else {
                    // Quality too low, delete file and request re-recording
                    outputFile.delete()
                    _recordingState.value = RecordingState.Error("Audio quality too low, please try again")
                    return@withContext null
                }
            } else {
                _recordingState.value = RecordingState.Error("No audio data recorded")
                return@withContext null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error stopping recording", e)
            _recordingState.value = RecordingState.Error("Failed to save recording: ${e.message}")
            null
        } finally {
            audioRecord?.release()
            audioRecord = null
        }
    }
    
    private fun readAudioData(): ShortArray {
        val audioRecord = this.audioRecord ?: return shortArrayOf()
        
        val audioData = mutableListOf<Short>()
        val buffer = ShortArray(BUFFER_SIZE / 2)
        
        while (audioRecord.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
            val readBytes = audioRecord.read(buffer, 0, buffer.size)
            if (readBytes > 0) {
                audioData.addAll(buffer.take(readBytes))
            }
        }
        
        return audioData.toShortArray()
    }
    
    private fun saveAsWav(audioData: ShortArray, outputFile: File) {
        try {
            FileOutputStream(outputFile).use { fos ->
                // Write WAV header
                writeWavHeader(fos, audioData.size)
                
                // Write audio data
                val byteBuffer = ByteBuffer.allocate(audioData.size * 2)
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN)
                
                for (sample in audioData) {
                    byteBuffer.putShort(sample)
                }
                
                fos.write(byteBuffer.array())
            }
            
            Log.d(TAG, "Saved WAV file: ${outputFile.absolutePath}")
        } catch (e: IOException) {
            Log.e(TAG, "Error saving WAV file", e)
            throw e
        }
    }
    
    private fun writeWavHeader(fos: FileOutputStream, audioDataSize: Int) {
        val header = ByteArray(44)
        val totalDataLen = audioDataSize * 2 + 36
        val bitRate = SAMPLE_RATE * 2 * 1 // 16-bit mono
        
        header[0] = 'R'.code.toByte()
        header[1] = 'I'.code.toByte()
        header[2] = 'F'.code.toByte()
        header[3] = 'F'.code.toByte()
        header[4] = (totalDataLen and 0xff).toByte()
        header[5] = (totalDataLen shr 8 and 0xff).toByte()
        header[6] = (totalDataLen shr 16 and 0xff).toByte()
        header[7] = (totalDataLen shr 24 and 0xff).toByte()
        header[8] = 'W'.code.toByte()
        header[9] = 'A'.code.toByte()
        header[10] = 'V'.code.toByte()
        header[11] = 'E'.code.toByte()
        header[12] = 'f'.code.toByte()
        header[13] = 'm'.code.toByte()
        header[14] = 't'.code.toByte()
        header[15] = ' '.code.toByte()
        header[16] = 16
        header[17] = 0
        header[18] = 0
        header[19] = 0
        header[20] = 1
        header[21] = 0
        header[22] = 1
        header[23] = 0
        header[24] = (SAMPLE_RATE and 0xff).toByte()
        header[25] = (SAMPLE_RATE shr 8 and 0xff).toByte()
        header[26] = (SAMPLE_RATE shr 16 and 0xff).toByte()
        header[27] = (SAMPLE_RATE shr 24 and 0xff).toByte()
        header[28] = (bitRate and 0xff).toByte()
        header[29] = (bitRate shr 8 and 0xff).toByte()
        header[30] = (bitRate shr 16 and 0xff).toByte()
        header[31] = (bitRate shr 24 and 0xff).toByte()
        header[32] = 2
        header[33] = 0
        header[34] = 16
        header[35] = 0
        header[36] = 'd'.code.toByte()
        header[37] = 'a'.code.toByte()
        header[38] = 't'.code.toByte()
        header[39] = 'a'.code.toByte()
        header[40] = (audioDataSize * 2 and 0xff).toByte()
        header[41] = (audioDataSize * 2 shr 8 and 0xff).toByte()
        header[42] = (audioDataSize * 2 shr 16 and 0xff).toByte()
        header[43] = (audioDataSize * 2 shr 24 and 0xff).toByte()
        
        fos.write(header)
    }
    
    private fun analyzeAudioQuality(audioData: ShortArray): AudioQualityMetrics {
        if (audioData.isEmpty()) {
            return AudioQualityMetrics(0, 0f, 0f, false)
        }
        
        val duration = (audioData.size.toFloat() / SAMPLE_RATE * 1000).toLong()
        
        // Calculate average amplitude
        val averageAmplitude = audioData.map { abs(it.toFloat()) }.average().toFloat()
        
        // Simple noise estimation (average absolute difference between consecutive samples)
        var sumDifferences = 0.0
        var countDifferences = 0
        var previous: Short? = null
        for (sample in audioData) {
            val prev = previous
            if (prev != null) {
                sumDifferences += kotlin.math.abs(sample.toInt() - prev.toInt())
                countDifferences += 1
            }
            previous = sample
        }
        val noise = if (countDifferences > 0) {
            (sumDifferences / countDifferences).toFloat()
        } else {
            0f
        }
        
        val signalToNoiseRatio = if (noise > 0) averageAmplitude / noise else Float.MAX_VALUE
        
        // Quality criteria
        val isGoodQuality = duration >= 2000 && // At least 2 seconds
                averageAmplitude > 1000 && // Sufficient volume
                signalToNoiseRatio > 5.0f && // Good SNR
                duration <= 15000 // Not too long (max 15 seconds)
        
        return AudioQualityMetrics(duration, averageAmplitude, signalToNoiseRatio, isGoodQuality)
    }
    
    fun getCurrentSentence(): String? {
        val session = _currentSession.value ?: return null
        return if (session.currentSentenceIndex < session.targetSentences.size) {
            session.targetSentences[session.currentSentenceIndex]
        } else {
            null
        }
    }
    
    fun getProgress(): Float {
        val session = _currentSession.value ?: return 0f
        return session.currentSentenceIndex.toFloat() / session.targetSentences.size.toFloat()
    }
    
    fun isSessionComplete(): Boolean {
        return _currentSession.value?.isComplete == true
    }
    
    fun getSessionSamples(): List<File> {
        return _currentSession.value?.recordedSamples ?: emptyList()
    }
    
    suspend fun cancelSession() {
        _currentSession.value?.let { session ->
            try {
                // Delete session directory and all samples
                val sessionDir = File(voiceCloneDir, session.sessionId)
                if (sessionDir.exists()) {
                    sessionDir.deleteRecursively()
                }
                
                Log.d(TAG, "Cancelled voice clone session: ${session.sessionId}")
            } catch (e: Exception) {
                Log.e(TAG, "Error cancelling session", e)
            }
        }
        
        _currentSession.value = null
        _recordingState.value = RecordingState.Idle
        
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null
    }
    
    fun hasActiveSession(): Boolean {
        return _currentSession.value != null && !isSessionComplete()
    }
}
