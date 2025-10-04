# JarvisAI Setup Guide

This guide will help you set up JarvisAI development environment and configure the app for optimal performance.

## Development Environment Setup

### Prerequisites
- **Android Studio**: Iguana (2024.1.1) or later
- **JDK**: 17 or later (recommend Eclipse Temurin)
- **Android SDK**: API Level 24+ (Android 7.0+)
- **Git**: For version control

### Step-by-Step Setup

1. **Install Android Studio**
   - Download from [Android Developer website](https://developer.android.com/studio)
   - Install with default settings
   - Install Android SDK and build tools

2. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/jarvisai.git
   cd jarvisai
   ```

3. **Open Project in Android Studio**
   - File → Open → Select the `jarvisai` folder
   - Wait for Gradle sync to complete
   - Resolve any SDK/NDK download prompts

4. **Configure Build Environment**
   ```bash
   # Create local.properties if not exists
   echo "sdk.dir=/path/to/your/android/sdk" > local.properties
   ```

## App Configuration

### Required Models

Place the following model files in `app/src/main/assets/`:

1. **Speech Emotion Recognition Model**
   ```
   app/src/main/assets/emotion_model.tflite
   ```
   - Download from: [Link to SER model] (will be provided)
   - Size: ~2-5MB
   - Supports 6 emotions: Neutral, Happy, Sad, Angry, Surprised, Frustrated

2. **Wake Word Models** (Future integration)
   ```
   app/src/main/assets/wake_word/
   ├── jarvis_en.ppn
   ├── hey_jarvis_en.ppn
   └── custom_wake_word.ppn
   ```

### Dependencies Configuration

The project uses version catalogs for dependency management. Key dependencies include:

```toml
# Core Android
androidx-core-ktx = "1.17.0"
androidx-lifecycle-runtime-ktx = "2.9.4"
androidx-activity-compose = "1.11.0"

# Compose
compose-bom = "2024.09.00"

# Architecture
room = "2.6.1"
hilt = "2.51.1"
navigation = "2.8.0"

# ML and Audio
tensorflow = "2.14.0"
lottie = "6.4.1"
```

## Build Configuration

### Gradle Configuration

The project supports multiple build variants:

```kotlin
android {
    buildTypes {
        debug {
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

### ProGuard Rules

For release builds, the following ProGuard rules are applied:

```proguard
# Keep TensorFlow Lite classes
-keep class org.tensorflow.lite.** { *; }

# Keep Room entities
-keep class com.jarvisai.data.entity.** { *; }

# Keep Hilt generated classes
-keep class dagger.hilt.** { *; }
```

## Permissions Setup

### Runtime Permissions

JarvisAI requires several runtime permissions. The app handles these gracefully:

```xml
<!-- Essential permissions -->
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.CALL_PHONE" />
<uses-permission android:name="android.permission.READ_CONTACTS" />

<!-- Android 13+ -->
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

### Permission Handling

The app uses [PermissionX](https://github.com/guolindev/PermissionX) for streamlined permission requests:

```kotlin
PermissionX.init(this)
    .permissions(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CALL_PHONE,
        Manifest.permission.READ_CONTACTS
    )
    .request { allGranted, _, _ ->
        if (allGranted) {
            // Initialize voice assistant
        }
    }
```

## Testing Setup

### Unit Tests

Run unit tests with:
```bash
./gradlew test
```

Key test files:
- `IntentParserTest.kt` - Tests command parsing logic
- `EmotionClassifierTest.kt` - Tests SER functionality
- `DeviceActionHandlerTest.kt` - Tests device action execution

### Instrumentation Tests

For UI and integration tests:
```bash
./gradlew connectedAndroidTest
```

### Testing on Device

1. Enable Developer Options
2. Enable USB Debugging
3. Install debug APK: `./gradlew installDebug`

## Performance Configuration

### Battery Optimization

Configure battery-aware features:

```kotlin
// In UserPreferences
data class UserPreferences(
    val isBatterySaverEnabled: Boolean = false,
    val wakeWordSensitivity: Float = 0.5f,
    // ...
)
```

### Audio Configuration

Optimize audio processing:

```kotlin
// In VoiceAssistantService
private val sampleRate = 16000 // 16kHz for optimal balance
private val channelConfig = AudioFormat.CHANNEL_IN_MONO
private val audioFormat = AudioFormat.ENCODING_PCM_16BIT
```

## Deployment Configuration

### Debug Builds

Debug builds include:
- Debug symbols
- Logging enabled
- No obfuscation
- Debuggable flag

### Release Builds

Release builds feature:
- Code obfuscation
- Resource shrinking
- APK optimization
- Signed with release keystore

### Play Store Preparation

1. **App Signing**
   ```bash
   # Generate keystore
   keytool -genkey -v -keystore jarvis-release.keystore \
     -alias jarvis -keyalg RSA -keysize 2048 -validity 10000
   ```

2. **App Bundle**
   ```bash
   ./gradlew bundleRelease
   ```

3. **Privacy Policy**
   - Required for apps with sensitive permissions
   - Include data collection disclosure
   - Specify local processing

## Troubleshooting

### Common Issues

1. **Gradle Sync Fails**
   - Check JDK version (should be 17+)
   - Clear Gradle cache: `./gradlew clean`
   - Invalidate caches in Android Studio

2. **Permission Denied Errors**
   - Ensure permissions are declared in manifest
   - Check runtime permission handling
   - Test on different API levels

3. **Audio Recording Issues**
   - Verify microphone permission
   - Test with different audio configurations
   - Check device compatibility

4. **TensorFlow Lite Model Loading**
   - Verify model file placement in assets
   - Check model format compatibility
   - Test model inference separately

### Debug Tools

1. **Logcat Filtering**
   ```bash
   adb logcat -s JarvisAI
   ```

2. **Network Monitoring**
   - Use Android Studio Network Inspector
   - Verify no unexpected network calls

3. **Memory Profiling**
   - Monitor memory usage during long sessions
   - Check for memory leaks in audio processing

## Production Considerations

### Security

1. **Code Obfuscation**
   - Enable ProGuard/R8 for release builds
   - Protect sensitive algorithms

2. **Certificate Pinning**
   - Pin certificates for any network calls
   - Implement certificate validation

3. **Root Detection**
   - Optional: Detect rooted devices
   - Warn users about security implications

### Privacy Compliance

1. **GDPR Compliance**
   - Implement data deletion
   - Provide data export functionality
   - Clear privacy notifications

2. **Local Processing**
   - Ensure all voice data stays local
   - No cloud dependencies for core features
   - User control over data storage

### Performance Monitoring

1. **Crash Reporting**
   - Integrate Firebase Crashlytics
   - Monitor crash-free sessions

2. **Performance Metrics**
   - Track wake word detection latency
   - Monitor battery usage patterns
   - Measure command success rates

This setup guide should get you up and running with JarvisAI development. For additional help, check the main README.md or open an issue on GitHub.
