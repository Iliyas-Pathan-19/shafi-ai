# JarvisAI Troubleshooting Guide

## 🚨 Common Issues and Solutions

### 1. **App Freezes After Onboarding**

**Symptoms:**
- App shows onboarding screen
- After completing setup, app becomes unresponsive
- No voice assistant functionality

**Root Causes & Solutions:**

#### A. Missing Permissions
```kotlin
// Check in MainActivity.kt
if (!permissionStatus.hasMinimumPermissions) {
    // Request permissions first
    PermissionManager.requestRequiredPermissions(this, permissionLauncher)
}
```

**Fix:** Ensure all required permissions are granted:
- `RECORD_AUDIO` - For voice input
- `INTERNET` - For cloud features
- `WAKE_LOCK` - For always-on service
- `MODIFY_AUDIO_SETTINGS` - For audio control

#### B. Service Not Starting
```kotlin
// Check if VoiceAssistantService is properly declared
val serviceIntent = Intent(this, VoiceAssistantService::class.java)
startService(serviceIntent)
```

**Fix:** Verify service declaration in AndroidManifest.xml:
```xml
<service
    android:name="com.jarvisai.assistant.core.service.VoiceAssistantService"
    android:enabled="true"
    android:exported="false"
    android:foregroundServiceType="microphone" />
```

#### C. Hilt Dependency Injection Issues
**Fix:** Check for missing `@Inject` annotations and ensure all modules are properly configured.

### 2. **NO-SOURCE Tasks in Gradle**

**Symptoms:**
- Build warnings about NO-SOURCE tasks
- Missing resources or assets

**Solutions:**

#### A. Check for Missing Assets
```bash
# Check assets directory
ls -la app/src/main/assets/
```

**Required Assets:**
- `vosk-models/` - Speech recognition models
- `tflite-models/` - Emotion recognition models (optional)

#### B. Verify Resource References
```kotlin
// Check if all drawable resources exist
R.drawable.ic_launcher_foreground
R.drawable.ic_launcher_background
```

### 3. **Permission Handling Issues**

**Symptoms:**
- App crashes when requesting permissions
- Permissions not granted properly
- Features don't work after permission grant

**Solutions:**

#### A. Use Proper Permission Request Pattern
```kotlin
class MainActivity : ComponentActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                // Initialize app
                initializeApp()
            }
        }
        
        // Request permissions
        permissionLauncher.launch(REQUIRED_PERMISSIONS)
    }
}
```

#### B. Handle Permission Denial Gracefully
```kotlin
if (!permissionStatus.hasMinimumPermissions) {
    // Show permission screen
    showPermissionScreen()
} else {
    // Continue with app initialization
    initializeApp()
}
```

### 4. **AI Freeze During Response Generation**

**Symptoms:**
- App becomes unresponsive during voice processing
- UI freezes when generating responses
- Memory issues

**Solutions:**

#### A. Use Background Threads
```kotlin
// Process voice in background
lifecycleScope.launch(Dispatchers.IO) {
    val result = processVoiceCommand(audioData)
    withContext(Dispatchers.Main) {
        updateUI(result)
    }
}
```

#### B. Implement Timeout Mechanisms
```kotlin
withTimeout(10000) { // 10 second timeout
    val result = processVoiceCommand(audioData)
}
```

#### C. Clear Chat History Periodically
```kotlin
// Limit chat history to prevent memory issues
if (chatHistory.size > MAX_HISTORY_SIZE) {
    chatHistory.removeAt(0)
}
```

### 5. **Deprecated Gradle Features**

**Symptoms:**
- Build warnings about deprecated features
- Compatibility issues with Gradle 9.0

**Solutions:**

#### A. Update Gradle Configuration
```kotlin
// build.gradle.kts
android {
    compileSdk = 36
    defaultConfig {
        minSdk = 24
        targetSdk = 36
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
}
```

#### B. Update Dependencies
```kotlin
// Use latest stable versions
implementation("androidx.compose:compose-bom:2024.02.00")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
```

### 6. **Missing File References**

**Symptoms:**
- App crashes when accessing files
- FileNotFoundException errors
- Broken asset references

**Solutions:**

#### A. Check File Paths
```kotlin
// Verify file exists before accessing
val file = File(context.filesDir, "model.tflite")
if (file.exists()) {
    // Use file
} else {
    Log.w("FileCheck", "Model file not found, using mock implementation")
}
```

#### B. Use Safe Asset Loading
```kotlin
try {
    val assetFileDescriptor = context.assets.openFd("model.tflite")
    // Load model
} catch (e: FileNotFoundException) {
    Log.w("AssetLoad", "Model not found, using fallback")
    // Use mock implementation
}
```

## 🔧 Debug Commands

### 1. **Check Build Issues**
```bash
./gradlew assembleDebug --warning-mode all
./gradlew clean
./gradlew build --stacktrace
```

### 2. **Check Permissions**
```bash
adb shell dumpsys package com.jarvisai | grep permission
```

### 3. **Check Service Status**
```bash
adb shell dumpsys activity services | grep VoiceAssistantService
```

### 4. **View Logs**
```bash
adb logcat | grep -E "(JarvisAI|VoiceAssistant|MainActivity)"
```

## 🚀 Best Practices

### 1. **Prevent Freezing**
- Use coroutines for long-running operations
- Implement proper error handling
- Add timeout mechanisms
- Clear resources when not needed

### 2. **Handle Permissions Properly**
- Request permissions at the right time
- Provide clear explanations
- Handle denial gracefully
- Check permissions before using features

### 3. **Optimize Performance**
- Use lazy initialization
- Implement proper caching
- Monitor memory usage
- Use background threads for heavy operations

### 4. **Debug Effectively**
- Add comprehensive logging
- Use debug helpers
- Test on different devices
- Monitor crash reports

## 📱 Testing Checklist

- [ ] App starts without crashing
- [ ] Permissions are requested properly
- [ ] Onboarding completes successfully
- [ ] Voice assistant responds to commands
- [ ] Service runs in background
- [ ] UI remains responsive
- [ ] No memory leaks
- [ ] Works on different Android versions

## 🆘 Emergency Fixes

### Quick Reset
1. Clear app data
2. Reinstall app
3. Grant all permissions
4. Restart device

### Debug Mode
1. Enable USB debugging
2. Check logs with `adb logcat`
3. Use debug helper to check state
4. Verify all dependencies are loaded

### Fallback Mode
1. Disable problematic features
2. Use mock implementations
3. Reduce functionality to core features
4. Gradually re-enable features
