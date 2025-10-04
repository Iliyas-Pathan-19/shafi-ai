@echo off
echo Building JarvisAI with Java 25 compatibility...

REM Set environment variables for Gradle
set GRADLE_OPTS=-Dorg.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8 --enable-native-access=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED

REM Try to build
.\gradlew clean :app:assembleDebug --no-daemon

if %ERRORLEVEL% neq 0 (
    echo Build failed. Trying alternative approach...
    set GRADLE_OPTS=-Dorg.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8 --enable-native-access=ALL-UNNAMED
    .\gradlew clean :app:assembleDebug --no-daemon
)

echo Build completed with exit code: %ERRORLEVEL%
pause