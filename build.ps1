# PowerShell script to build with proper Java configuration
Write-Host "Building JarvisAI with Java 25 compatibility..." -ForegroundColor Green

# Set environment variables for Gradle
$env:GRADLE_OPTS = "-Dorg.gradle.java.home= -Dorg.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8 --enable-native-access=ALL-UNNAMED"

# Try to build with current Java version
Write-Host "Attempting build with current Java version..." -ForegroundColor Yellow
.\gradlew clean :app:assembleDebug --no-daemon

if ($LASTEXITCODE -ne 0) {
    Write-Host "Build failed with current Java version. Trying alternative approach..." -ForegroundColor Red
    
    # Try with different Gradle options
    $env:GRADLE_OPTS = "-Dorg.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8 --enable-native-access=ALL-UNNAMED -Dkotlin.daemon.jvm.options=-Xmx2048m"
    .\gradlew clean :app:assembleDebug --no-daemon
}

Write-Host "Build completed with exit code: $LASTEXITCODE" -ForegroundColor Cyan
