# JarvisAI Voice Features Documentation

This document details the advanced voice processing capabilities of JarvisAI, including Automatic Speech Recognition (ASR), Text-to-Speech (TTS), and Voice Cloning.

## 🎤 Automatic Speech Recognition (ASR)

### Vosk Integration

JarvisAI uses Vosk for offline speech recognition, providing privacy-first voice processing.

#### Features
- **Offline Processing**: All speech recognition happens locally
- **Real-time Recognition**: Streaming audio processing with partial results
- **High Accuracy**: Optimized for English voice commands
- **Low Latency**: Fast response times for interactive use

#### Model Requirements

Place Vosk models in `app/src/main/assets/vosk-models/`:

```
app/src/main/assets/vosk-models/
└── vosk-model-small-en-us-0.15/
    ├── am/
    ├── conf/
    ├── graph/
    ├── ivector/
    └── ... (model files)
```

#### Supported Models
- **vosk-model-small-en-us-0.15** (Recommended): ~40MB, good accuracy/size balance
- **vosk-model-en-us-0.22**: ~1.8GB, highest accuracy
- **vosk-model-en-us-0.22-lgraph**: ~128MB, medium accuracy

#### Usage Example

```kotlin
// Initialize ASR
val voskASR = VoskASR(context)
val initialized = voskASR.initialize()

// Start listening
voskASR.startListening()

// Process audio data
val audioData: ShortArray = ... // Audio samples
val result = voskASR.processAudioData(audioData)

result?.let { asrResult ->
    println("Recognized: ${asrResult.text}")
    println("Confidence: ${asrResult.confidence}")
    println("Final: ${asrResult.isFinal}")
}

// Stop and release
voskASR.stopListening()
voskASR.release()
```

#### Configuration

```kotlin
// Audio configuration
private val SAMPLE_RATE = 16000 // 16kHz sample rate
private val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
private val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
```

## 🗣️ Text-to-Speech (TTS)

### Enhanced TTS System

JarvisAI features an advanced TTS system with emotion-aware responses and voice customization.

#### Features
- **System Voice Integration**: Uses Android's built-in TTS engines
- **Emotion-Aware Speech**: Adjusts pitch and speed based on detected emotions
- **Voice Selection**: Multiple voice options and quality levels
- **Custom Voice Cloning**: Create personalized voices (local processing)
- **Speech Control**: Pitch, speed, and pause controls

#### Voice Types

```kotlin
enum class VoiceQuality {
    LOW, NORMAL, HIGH, VERY_HIGH
}

data class TTSVoice(
    val id: String,
    val name: String,
    val language: String,
    val quality: VoiceQuality,
    val isCloned: Boolean = false,
    val clonePath: String? = null
)
```

#### Emotion-Based Speech Adjustments

| Emotion | Pitch Modifier | Speed Modifier | Effect |
|---------|---------------|----------------|---------|
| Happy/Excited | 1.2x | 1.1x | Higher pitch, faster |
| Sad/Disappointed | 0.8x | 0.9x | Lower pitch, slower |
| Angry/Frustrated | 1.1x | 1.2x | Slightly higher, faster |
| Surprised | 1.3x | 1.0x | Higher pitch, normal speed |
| Calm/Neutral | 1.0x | 1.0x | Normal parameters |

#### Usage Example

```kotlin
// Initialize TTS
val jarvisTTS = JarvisTTS(context)
val initialized = jarvisTTS.initialize()

// Create TTS request
val voice = TTSVoice(
    id = "en-us-variant",
    name = "US English",
    language = "English",
    quality = VoiceQuality.HIGH
)

val request = TTSRequest(
    text = "Hello! How can I help you today?",
    voice = voice,
    pitch = 1.0f,
    speed = 1.0f,
    emotion = "happy"
)

// Speak
val success = jarvisTTS.speak(request)

// Control playback
jarvisTTS.pause()
jarvisTTS.resume()
jarvisTTS.stop()
```

## 🎭 Voice Cloning

### Personal Voice Creation

Create custom voices using a few audio samples for a personalized assistant experience.

#### Features
- **Sample-Based Training**: 5-10 voice samples for clone creation
- **Quality Analysis**: Automatic audio quality assessment
- **Local Processing**: All voice cloning happens on-device
- **WAV Format Support**: High-quality 22kHz audio recording
- **Session Management**: Guided recording process

#### Voice Clone Process

1. **Session Creation**: Start with user's name
2. **Guided Recording**: Read predefined sentences
3. **Quality Check**: Automatic assessment of each recording
4. **Clone Generation**: Process samples into voice model
5. **Integration**: Available in voice selection

#### Training Prompts

The system uses carefully selected sentences to capture voice characteristics:

```kotlin
private val trainingPrompts = listOf(
    "Hello, my name is Jarvis and I'm your personal assistant.",
    "I can help you with calls, messages, navigation, and many other tasks.",
    "What would you like me to help you with today?",
    "I understand your request and I'll take care of it right away.",
    "Is there anything else I can help you with?",
    // ... more sentences
)
```

#### Audio Quality Metrics

```kotlin
data class AudioQualityMetrics(
    val duration: Long,          // Minimum 2 seconds
    val averageAmplitude: Float, // Volume level check
    val signalToNoiseRatio: Float, // Audio clarity
    val isGoodQuality: Boolean   // Overall assessment
)
```

#### Usage Example

```kotlin
// Start voice clone session
val recorder = VoiceCloneRecorder(context)
val session = recorder.startVoiceCloneSession("My Voice")

// Record each sentence
recorder.startRecording()
// ... user speaks
val audioFile = recorder.stopRecording()

// Complete session
if (recorder.isSessionComplete()) {
    val samples = recorder.getSessionSamples()
    val voiceClone = jarvisTTS.createVoiceClone("My Voice", samples)
}
```

## 🎯 Integration with Assistant Service

### Complete Voice Pipeline

The voice features are fully integrated into the main `VoiceAssistantService`:

```kotlin
private suspend fun startCommandListening() {
    // Start ASR
    voskASR.startListening()
    
    // Process audio with emotion detection
    val asrResult = voskASR.processAudioData(audioChunk)
    val emotionResult = emotionClassifier.classifyEmotion(features)
    
    // Create voice input with emotion
    val voiceInput = VoiceInput(
        transcript = asrResult.text,
        confidence = asrResult.confidence,
        detectedEmotion = emotionResult?.emotion,
        emotionConfidence = emotionResult?.confidence
    )
    
    // Generate response with TTS
    val responseText = generateResponse(command, voiceInput.detectedEmotion?.name)
    val ttsRequest = TTSRequest(
        text = responseText,
        voice = selectedVoice,
        emotion = voiceInput.detectedEmotion?.name
    )
    
    jarvisTTS.speak(ttsRequest)
}
```

## 📱 User Interface

### Voice Clone Screen

The app includes a dedicated voice cloning interface:

- **Voice Clone List**: View and manage existing clones
- **Recording Session**: Guided voice recording process
- **Progress Tracking**: Visual progress indicators
- **Quality Feedback**: Real-time audio quality assessment

### Settings Integration

Voice features are accessible through the settings screen:

- **Voice Selection**: Choose from system and cloned voices
- **Voice Cloning**: Access to voice clone management
- **TTS Preferences**: Pitch, speed, and quality settings

## 🔧 Technical Requirements

### Dependencies

```kotlin
// Vosk ASR
implementation("com.alphacephei:vosk-android:0.3.45")

// JSON processing
implementation("org.json:json:20231013")

// Android TTS (built-in)
// TextToSpeech class from Android framework
```

### Permissions

```xml
<!-- Required for voice recording -->
<uses-permission android:name="android.permission.RECORD_AUDIO" />

<!-- Optional for external storage -->
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

### Storage Requirements

| Component | Storage Size | Location |
|-----------|-------------|----------|
| Vosk Model (Small) | ~40MB | `app/src/main/assets/` |
| Voice Clones | ~1-5MB each | `app_data/voice_clones/` |
| Audio Samples | ~100KB each | `app_data/voice_cloning/` |

## 🧪 Testing

### Unit Tests

```bash
# Test ASR functionality
./gradlew :assistant-core:testDebugUnitTest --tests "*VoskASRTest*"

# Test TTS functionality  
./gradlew :assistant-core:testDebugUnitTest --tests "*JarvisTTSTest*"
```

### Integration Tests

```bash
# Test complete voice pipeline
./gradlew :app:connectedDebugAndroidTest --tests "*VoiceIntegrationTest*"
```

## 🚀 Performance Optimization

### Battery Efficiency
- **Adaptive Sampling**: Reduce sample rate during low battery
- **Smart Buffering**: Efficient audio buffer management
- **Background Processing**: Coroutine-based async processing

### Memory Management
- **Model Caching**: Efficient model loading and unloading
- **Audio Streaming**: Process audio in chunks
- **Resource Cleanup**: Proper cleanup of audio resources

### Latency Optimization
- **Streaming Recognition**: Real-time partial results
- **Model Optimization**: Use smaller models for faster processing
- **Pipeline Optimization**: Overlapped processing stages

## 🔒 Privacy & Security

### Local Processing
- **No Cloud Dependencies**: All processing happens on-device
- **Encrypted Storage**: Voice clones stored securely
- **User Control**: Complete control over voice data

### Data Management
- **Selective Deletion**: Delete individual voice clones
- **Clear All Data**: Option to remove all voice data
- **Export Control**: No automatic data sharing

## 🔮 Future Enhancements

### Planned Features
- **Multi-language Support**: Additional language models
- **Voice Style Transfer**: Change speaking style
- **Noise Cancellation**: Improved audio quality
- **Real-time Processing**: Lower latency recognition

### Advanced Voice Cloning
- **Few-shot Learning**: Fewer samples required
- **Voice Conversion**: Transform voice characteristics
- **Emotion Synthesis**: Generate emotional speech
- **Speaker Adaptation**: Adaptive voice models

This comprehensive voice system provides JarvisAI with state-of-the-art speech capabilities while maintaining privacy and user control.
