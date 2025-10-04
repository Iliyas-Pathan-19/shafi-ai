@echo off
echo Setting up JDK 17 for Gradle build...

REM Create a temporary directory for JDK 17
set JDK17_DIR=%TEMP%\jdk17
if not exist "%JDK17_DIR%" mkdir "%JDK17_DIR%"

REM Download JDK 17 if not already present
if not exist "%JDK17_DIR%\bin\java.exe" (
    echo Downloading JDK 17...
    powershell -Command "Invoke-WebRequest -Uri 'https://download.java.net/java/GA/jdk17.0.2/dfd4a8d0985749f896bed50d7138ee7f/8/GPL/openjdk-17.0.2_windows-x64_bin.zip' -OutFile '%JDK17_DIR%\jdk17.zip'"
    powershell -Command "Expand-Archive -Path '%JDK17_DIR%\jdk17.zip' -DestinationPath '%JDK17_DIR%' -Force"
    powershell -Command "Move-Item '%JDK17_DIR%\jdk-17.0.2' '%JDK17_DIR%\jdk17' -Force"
    del "%JDK17_DIR%\jdk17.zip"
)

REM Set JAVA_HOME to JDK 17
set JAVA_HOME=%JDK17_DIR%\jdk17
set PATH=%JAVA_HOME%\bin;%PATH%

echo Using Java version:
java -version

echo Building project...
.\gradlew clean :app:assembleDebug --no-daemon

pause
