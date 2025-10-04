# JarvisAI - Personal Voice Assistant

![Android CI](https://github.com/yourusername/jarvisai/workflows/Android%20CI/badge.svg)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)

JarvisAI is a privacy-first, offline-capable voice assistant for Android that puts you in control. Unlike cloud-based assistants, JarvisAI processes your voice commands locally, ensuring your privacy while providing intelligent assistance.

## ✨ Features

### 🎤 Advanced Voice Processing
- **Offline ASR**: Vosk speech recognition for privacy-first processing
- **Smart TTS**: Emotion-aware text-to-speech with voice customization
- **Voice Cloning**: Create personalized assistant voices with local samples
- **Wake Word Detection**: Customizable wake words ("Hey Jarvis", "Hey [Your Name]")
- **Battery Optimization**: Adaptive processing for extended battery life

### 🧠 Intelligent Command Processing
- **Calls**: "Hey Jarvis, call John Doe"
- **Messaging**: "Hey Jarvis, send 'Hello' to Sarah on WhatsApp"
- **Media Control**: "Hey Jarvis, play some music"
- **Navigation**: "Hey Jarvis, navigate to Central Park"
- **Device Actions**: "Hey Jarvis, lock my screen"
- **Research**: "Hey Jarvis, search for weather today"

### 🎭 Emotion-Aware Responses
- Speech Emotion Recognition (SER) using TensorFlow Lite
- Adaptive response tone based on detected emotion
- Supports 6 emotions: Neutral, Happy, Sad, Angry, Surprised, Frustrated

### 🔒 Privacy-First Design
- All voice processing happens locally on device
- No cloud dependencies for core functionality
- Optional voice cloning with explicit user consent
- Complete control over data storage and deletion

### 🎨 Modern Android UI
- Material 3 design system
- Jetpack Compose UI
- Animated Lottie avatar
- Accessibility-first design with TalkBack support

## 🏗️ Architecture

JarvisAI follows a modular architecture with clean separation of concerns:

```
app/                 # Main application module (UI, Navigation)
├── assistant-core/  # Core assistant logic (Wake word, ASR, Intent parsing)
├── data/           # Data layer (Room database, Repositories)
├── device-actions/ # Device action handlers (Calls, Messages, etc.)
└── ml/             # Machine learning (Speech Emotion Recognition)
```

### Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose with Material 3
- **Database**: Room
- **DI**: Hilt
- **Architecture**: MVVM with Repository pattern
- **ML**: TensorFlow Lite
- **Audio**: AudioRecord, Android TTS
- **Async**: Coroutines & Flow

## 🚀 Getting Started

### Prerequisites
- Android Studio Iguana or later
- JDK 17 or later
- Android SDK 24+ (Android 7.0+)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/jarvisai.git
   cd jarvisai
   ```

2. **Open in Android Studio**
   - Import the project
   - Let Gradle sync

3. **Run the app**
   - Connect an Android device or start an emulator
   - Click "Run" or use `./gradlew installDebug`

### First Run
1. Complete the onboarding process
2. Grant required permissions (Microphone, Phone, Contacts)
3. Customize your assistant name and voice preferences
4. Start using voice commands!

## 📱 Permissions Required

### Essential Permissions
- **RECORD_AUDIO**: Voice command processing and wake word detection
- **CALL_PHONE**: Making phone calls through voice commands
- **READ_CONTACTS**: Finding contacts by name
- **POST_NOTIFICATIONS**: Service status notifications (Android 13+)

### Optional Permissions
- **SEND_SMS**: Sending text messages
- **MODIFY_AUDIO_SETTINGS**: Volume control commands
- **ACCESS_NOTIFICATION_POLICY**: Do Not Disturb control

## 🔧 Configuration

### Voice Models
Place voice models in `app/src/main/assets/`:
- `emotion_model.tflite` - Speech Emotion Recognition model
- Voice wake word models (when integrated with Porcupine)

### Customization
- Assistant name and user nickname
- Voice selection and cloning
- Emotion recognition toggle
- Wake word sensitivity
- Battery saver mode

## 🧪 Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumentation Tests
```bash
./gradlew connectedAndroidTest
```

### Lint
```bash
./gradlew lintDebug
```

## 🚀 CI/CD

The project includes GitHub Actions workflows for:
- **Build & Test**: Automated testing and APK generation
- **Lint**: Code quality checks
- **Security**: Dependency vulnerability scanning

## 📊 Performance Metrics

### Target Performance
- Wake word detection latency: < 400ms
- Battery drain (idle): < 5% per hour
- Offline command success rate: > 90%
- User satisfaction: > 4.5/5

### Battery Optimization
- Adaptive audio sampling based on battery level
- Coroutine-based audio processing
- Foreground service with low-priority notification
- Background processing restrictions compliance

## 🔮 Future Enhancements

### Planned Features
- [ ] Porcupine wake word engine integration
- [x] Vosk ASR for improved offline recognition ✅
- [x] Advanced TTS with emotion awareness ✅
- [x] Custom voice model training ✅
- [ ] Plugin system for third-party integrations
- [ ] Multi-language support
- [ ] Smart home device control
- [ ] Coqui TTS for neural voice synthesis

### Advanced ML Features
- [ ] Personalized command learning
- [ ] Context-aware responses
- [ ] Conversation memory
- [ ] Sentiment analysis improvements

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guidelines](CONTRIBUTING.md) for details.

### Development Setup
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

- **Issues**: [GitHub Issues](https://github.com/yourusername/jarvisai/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/jarvisai/discussions)
- **Documentation**: [Wiki](https://github.com/yourusername/jarvisai/wiki)

## 🙏 Acknowledgments

- [Material 3 Design](https://m3.material.io/) for UI components
- [TensorFlow Lite](https://tensorflow.org/lite) for on-device ML
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for modern UI
- [Hilt](https://dagger.dev/hilt/) for dependency injection

---

**Privacy Notice**: JarvisAI is designed with privacy as a core principle. All voice processing happens locally on your device. No voice data is transmitted to external servers unless explicitly configured by the user.
