# PowerShell script to download and setup JDK 17
Write-Host "Setting up JDK 17 for JarvisAI build..." -ForegroundColor Green

# Create a temporary directory for JDK 17
$JDK17_DIR = "$env:TEMP\jdk17"
if (!(Test-Path $JDK17_DIR)) {
    New-Item -ItemType Directory -Path $JDK17_DIR -Force
}

# Check if JDK 17 is already downloaded
$javaExe = "$JDK17_DIR\bin\java.exe"
if (!(Test-Path $javaExe)) {
    Write-Host "Downloading JDK 17..." -ForegroundColor Yellow
    
    # Download JDK 17 from Eclipse Adoptium
    $jdkUrl = "https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.9%2B9/OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.zip"
    $jdkZip = "$JDK17_DIR\jdk17.zip"
    
    try {
        Invoke-WebRequest -Uri $jdkUrl -OutFile $jdkZip -UseBasicParsing
        Write-Host "Downloaded JDK 17 successfully" -ForegroundColor Green
        
        # Extract the zip file
        Expand-Archive -Path $jdkZip -DestinationPath $JDK17_DIR -Force
        Remove-Item $jdkZip -Force
        
        # Find the extracted JDK directory
        $jdkDirs = Get-ChildItem -Path $JDK17_DIR -Directory | Where-Object { $_.Name -like "jdk*" }
        if ($jdkDirs.Count -gt 0) {
            $jdkDir = $jdkDirs[0].FullName
            # Move contents to the expected location
            Get-ChildItem -Path $jdkDir -Recurse | ForEach-Object {
                $newPath = $_.FullName.Replace($jdkDir, "$JDK17_DIR")
                $newDir = Split-Path $newPath -Parent
                if (!(Test-Path $newDir)) {
                    New-Item -ItemType Directory -Path $newDir -Force
                }
                if ($_.PSIsContainer) {
                    if (!(Test-Path $newPath)) {
                        New-Item -ItemType Directory -Path $newPath -Force
                    }
                } else {
                    Copy-Item $_.FullName -Destination $newPath -Force
                }
            }
            Remove-Item $jdkDir -Recurse -Force
        }
        
        Write-Host "JDK 17 setup completed" -ForegroundColor Green
    } catch {
        Write-Host "Failed to download JDK 17: $($_.Exception.Message)" -ForegroundColor Red
        Write-Host "Please download JDK 17 manually and place it in $JDK17_DIR" -ForegroundColor Yellow
        exit 1
    }
} else {
    Write-Host "JDK 17 already exists" -ForegroundColor Green
}

# Set JAVA_HOME to JDK 17
$env:JAVA_HOME = $JDK17_DIR
$env:PATH = "$JDK17_DIR\bin;$env:PATH"

Write-Host "Using Java version:" -ForegroundColor Cyan
& "$JDK17_DIR\bin\java.exe" -version

Write-Host "Building project with JDK 17..." -ForegroundColor Green
.\gradlew clean :app:assembleDebug --no-daemon

Write-Host "Build completed with exit code: $LASTEXITCODE" -ForegroundColor Cyan
