package com.jarvisai.assistant.core.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.media.*
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import android.util.Log
import com.jarvisai.assistant.core.model.VoiceInput
import com.jarvisai.assistant.core.parser.IntentParser
import com.jarvisai.assistant.core.asr.VoskASR
import com.jarvisai.assistant.core.tts.JarvisTTS
import com.jarvisai.assistant.core.tts.TTSRequest
import com.jarvisai.assistant.core.tts.TTSVoice
import com.jarvisai.assistant.core.emotion.EmotionAnalyzer
import com.jarvisai.assistant.core.wakeword.WakeWordDetector
import com.jarvisai.data.repository.CommandHistoryRepository
import com.jarvisai.data.repository.UserPreferencesRepository
import com.jarvisai.assistant.core.actions.DeviceActionHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@AndroidEntryPoint
class VoiceAssistantService : LifecycleService() {
    
    @Inject lateinit var intentParser: IntentParser
    @Inject lateinit var commandHistoryRepository: CommandHistoryRepository
    @Inject lateinit var userPreferencesRepository: UserPreferencesRepository
    @Inject lateinit var voskASR: VoskASR
    @Inject lateinit var jarvisTTS: JarvisTTS
    @Inject lateinit var emotionClassifier: EmotionAnalyzer
    @Inject lateinit var deviceActionHandler: DeviceActionHandler
    @Inject lateinit var wakeWordDetector: WakeWordDetector
    
    private var audioRecord: AudioRecord? = null
    private var isListening = false
    private var wakeWordDetected = false
    
    private val binder = VoiceAssistantBinder()
    private val isDebug: Boolean by lazy {
        (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
    }
    
    // Audio configuration
    private val sampleRate = 16000
    private val channelConfig = AudioFormat.CHANNEL_IN_MONO
    private val audioFormat = AudioFormat.ENCODING_PCM_16BIT
    private val bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat)
    
    // Notification
    private val CHANNEL_ID = "VOICE_ASSISTANT_CHANNEL"
    private val NOTIFICATION_ID = 1
    
    // Wake word simulation (placeholder for Porcupine integration)
    private val wakeWords = setOf("hey jarvis", "hey shafi", "jarvis", "assistant")
    
    inner class VoiceAssistantBinder : Binder() {
        fun getService(): VoiceAssistantService = this@VoiceAssistantService
    }
    
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startForeground(NOTIFICATION_ID, createNotification())
        
        // Initialize voice components
        lifecycleScope.launch {
            initializeVoiceComponents()
        }
        
        // Observe user preferences for assistant name
        lifecycleScope.launch {
            userPreferencesRepository.getUserPreferences()
                .collect { preferences ->
                    // Update wake words based on assistant name
                    updateWakeWords(preferences.assistantName)
                }
        }
    }
    
    private suspend fun initializeVoiceComponents() {
        try {
            // Initialize Wake Word Detector
            val wakeWordInitialized = wakeWordDetector.initialize()
            Log.d("VoiceService", "Wake word detector initialized: $wakeWordInitialized")
            
            // Initialize ASR
            val asrInitialized = voskASR.initialize()
            Log.d("VoiceService", "ASR initialized: $asrInitialized")
            
            // Initialize TTS
            val ttsInitialized = jarvisTTS.initialize()
            Log.d("VoiceService", "TTS initialized: $ttsInitialized")
            
            // Initialize Emotion Classifier
            val emotionInitialized = emotionClassifier.initialize()
            Log.d("VoiceService", "Emotion classifier initialized: $emotionInitialized")
            
        } catch (e: Exception) {
            Log.e("VoiceService", "Error initializing voice components", e)
        }
    }
    
    private fun updateWakeWords(assistantName: String) {
        // Update wake word patterns based on assistant name
        val wakeWords = listOf(
            "hey $assistantName",
            "hey ${assistantName.lowercase()}",
            assistantName,
            "assistant"
        )
        wakeWordDetector.setWakeWords(wakeWords)
        Log.d("VoiceService", "Updated wake words for assistant: $assistantName")
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        
        when (intent?.action) {
            ACTION_START_LISTENING -> startListening()
            ACTION_STOP_LISTENING -> stopListening()
            ACTION_WAKE_WORD_DETECTED -> handleWakeWordDetected()
        }
        
        return START_STICKY
    }
    
    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)
        return binder
    }
    
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Voice Assistant",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "JarvisAI Voice Assistant Service"
                setShowBadge(false)
            }
            
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    
    private fun createNotification(): Notification {
        val stopIntent = Intent(this, VoiceAssistantService::class.java).apply {
            action = ACTION_STOP_LISTENING
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 0, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("JarvisAI")
            .setContentText(if (isListening) "Listening for wake word..." else "Tap to start listening")
            .setSmallIcon(android.R.drawable.ic_btn_speak_now)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setOngoing(true)
            .addAction(
                android.R.drawable.ic_media_pause,
                "Stop",
                stopPendingIntent
            )
            .build()
    }
    
    private fun updateNotification(text: String) {
        val notification = createNotification()
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
    }
    
    fun startListening() {
        if (isListening) return
        
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) 
            != PackageManager.PERMISSION_GRANTED) {
            return
        }
        
        try {
            audioRecord = AudioRecord(
                MediaRecorder.AudioSource.MIC,
                sampleRate,
                channelConfig,
                audioFormat,
                bufferSize
            )
            
            if (audioRecord?.state == AudioRecord.STATE_INITIALIZED) {
                audioRecord?.startRecording()
                isListening = true
                
                // Start audio processing in background
                lifecycleScope.launch(Dispatchers.IO) {
                    processAudioStream()
                }
                
                updateNotification("Listening for wake word...")
                // Greet the user to confirm readiness
                lifecycleScope.launch {
                    try {
                        val prefs = userPreferencesRepository.getUserPreferences().first()
                        val nick = prefs.userNickname ?: "there"
                        val greet = "Hi ${nick}, I'm listening."
                        jarvisTTS.speak(
                            com.jarvisai.assistant.core.tts.TTSRequest(
                                text = greet,
                                voice = com.jarvisai.assistant.core.tts.TTSVoice(
                                    id = "default",
                                    name = "Default",
                                    language = "en",
                                    quality = com.jarvisai.assistant.core.tts.VoiceQuality.NORMAL
                                )
                            )
                        )
                    } catch (_: Exception) { }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    fun stopListening() {
        isListening = false
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null
        updateNotification("Tap to start listening")
    }
    
    private suspend fun processAudioStream() {
        val buffer = ShortArray(bufferSize)
        
        // Start wake word detector
        wakeWordDetector.startListening()
        
        while (isListening && audioRecord?.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
            val bytesRead = audioRecord?.read(buffer, 0, buffer.size) ?: 0
            
            if (bytesRead > 0) {
                // Process audio with wake word detector
                val detectionResult = wakeWordDetector.processAudioData(buffer)
                if (detectionResult?.detected == true) {
                    handleWakeWordDetected()
                }
            }
            
            delay(100) // Small delay to prevent excessive CPU usage
        }
        
        // Stop wake word detector
        wakeWordDetector.stopListening()
    }
    
    
    private fun handleWakeWordDetected() {
        if (wakeWordDetected) return
        
        wakeWordDetected = true
        updateNotification("Wake word detected! Listening for command...")
        
        // Start command listening session
        lifecycleScope.launch {
            startCommandListening()
        }
    }
    
    private suspend fun startCommandListening() {
        try {
            updateNotification("Listening for command...")
            
            // Start ASR listening
            voskASR.startListening()
            
            // Collect ASR results for up to 5 seconds
            val audioBuffer = mutableListOf<Short>()
            val startTime = System.currentTimeMillis()
            val maxListeningTime = 5000L // 5 seconds
            
            while (isListening && System.currentTimeMillis() - startTime < maxListeningTime) {
                val buffer = ShortArray(bufferSize / 2)
                val bytesRead = audioRecord?.read(buffer, 0, buffer.size) ?: 0
                
                if (bytesRead > 0) {
                    audioBuffer.addAll(buffer.take(bytesRead))
                    
                    // Process audio with Vosk every 1000ms of audio
                    if (audioBuffer.size >= sampleRate) {
                        val audioChunk = audioBuffer.take(sampleRate).toShortArray()
                        audioBuffer.removeAll(audioBuffer.take(sampleRate))
                        
                        val asrResult = voskASR.processAudioData(audioChunk)
                        if (asrResult?.isFinal == true && asrResult.text.isNotBlank()) {
                            // Process the recognized text with TensorFlow emotion analysis
                            val detectedEmotion = if (emotionClassifier.isModelLoaded()) {
                                emotionClassifier.analyzeEmotion(audioChunk)
                            } else null
                            
                            val voiceInput = VoiceInput(
                                transcript = asrResult.text,
                                confidence = asrResult.confidence,
                                detectedEmotion = detectedEmotion,
                                emotionConfidence = 0.8f
                            )
                            
                            processVoiceCommand(voiceInput)
                            break
                        }
                    }
                }
                
                delay(100) // Small delay to prevent excessive CPU usage
            }
            
            // Stop ASR
            voskASR.stopListening()
            
            // Reset wake word detection
            wakeWordDetected = false
            updateNotification("Listening for wake word...")
            
        } catch (e: Exception) {
            Log.e("VoiceService", "Error during command listening", e)
            updateNotification("Error during voice recognition")
            wakeWordDetected = false
        }
    }
    
    private suspend fun processVoiceCommand(voiceInput: VoiceInput) {
        val command = intentParser.parseCommand(voiceInput.transcript)
        
        // Execute the command and get result
        val commandResult = try {
            deviceActionHandler.executeCommand(command)
        } catch (e: Exception) {
            Log.e("VoiceService", "Error executing command", e)
            com.jarvisai.assistant.core.model.CommandResult(
                command = command,
                success = false,
                message = "Failed to execute command: ${e.message}"
            )
        }
        
        // Generate appropriate response based on emotion and command result
        val responseText = generateResponse(commandResult, voiceInput.detectedEmotion?.name)
        
        // Get user preferences for TTS
        val preferences = userPreferencesRepository.getUserPreferences().first()
        
        // Create TTS request with emotion-aware parameters
        val ttsVoice = TTSVoice(
            id = preferences.selectedVoice,
            name = preferences.selectedVoice,
            language = "English",
            quality = com.jarvisai.assistant.core.tts.VoiceQuality.NORMAL
        )
        
        val ttsRequest = TTSRequest(
            text = responseText,
            voice = ttsVoice,
            emotion = voiceInput.detectedEmotion?.name
        )
        
        // Speak the response
        val speechSuccess = jarvisTTS.speak(ttsRequest)
        
        // Log command to history
        commandHistoryRepository.insertCommand(
            command = command.toString(),
            transcript = voiceInput.transcript,
            response = responseText,
            successful = commandResult.success && speechSuccess,
            detectedEmotion = voiceInput.detectedEmotion?.name,
            confidence = voiceInput.confidence
        )
        
        // Update notification
        updateNotification("Response: $responseText")
        
        delay(3000) // Give time for speech to complete
        updateNotification("Listening for wake word...")
    }
    
    private fun generateResponse(commandResult: com.jarvisai.assistant.core.model.CommandResult, emotion: String?): String {
        val baseResponse = if (commandResult.success) {
            commandResult.message
        } else {
            "I'm sorry, I couldn't ${getActionDescription(commandResult.command)}. ${commandResult.message}"
        }
        
        // Modify response based on detected emotion
        return when (emotion?.lowercase()) {
            "happy" -> "Great! $baseResponse"
            "sad" -> "Of course. $baseResponse"
            "angry", "frustrated" -> "Right away. $baseResponse"
            "surprised" -> "Oh! $baseResponse"
            else -> baseResponse
        }
    }
    
    private fun getActionDescription(command: com.jarvisai.assistant.core.model.Command): String {
        return when (command) {
            is com.jarvisai.assistant.core.model.Command.Call -> "make that call"
            is com.jarvisai.assistant.core.model.Command.Message -> "send that message"
            is com.jarvisai.assistant.core.model.Command.PlayMedia -> "play that media"
            is com.jarvisai.assistant.core.model.Command.Navigate -> "navigate there"
            is com.jarvisai.assistant.core.model.Command.DeviceAction -> command.action.name.lowercase().replace("_", " ")
            is com.jarvisai.assistant.core.model.Command.Research -> "search for that"
            is com.jarvisai.assistant.core.model.Command.Unknown -> "understand that command"
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        stopListening()
    }
    
    companion object {
        const val ACTION_START_LISTENING = "com.jarvisai.START_LISTENING"
        const val ACTION_STOP_LISTENING = "com.jarvisai.STOP_LISTENING"
        const val ACTION_WAKE_WORD_DETECTED = "com.jarvisai.WAKE_WORD_DETECTED"
    }
}
