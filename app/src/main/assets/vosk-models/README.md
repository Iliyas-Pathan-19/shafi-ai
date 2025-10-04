# Vosk Models

This directory should contain the Vosk speech recognition models.

## Required Model

For the app to work properly, you need to download and place the following model in this directory:

- **Model Name**: `vosk-model-small-en-us-0.15`
- **Download URL**: https://alphacephei.com/vosk/models
- **Direct Link**: https://alphacephei.com/vosk/models/vosk-model-small-en-us-0.15.zip

## Installation Instructions

1. Download the model zip file from the URL above
2. Extract the zip file
3. Place the extracted folder `vosk-model-small-en-us-0.15` directly in this directory
4. The final structure should be: `app/src/main/assets/vosk-models/vosk-model-small-en-us-0.15/`

## Alternative Models

You can also use other Vosk models:
- `vosk-model-en-us-0.22` (larger, more accurate)
- `vosk-model-small-en-us-0.22` (newer version)

Just update the `MODEL_NAME` constant in `VoskASR.kt` to match your chosen model.

## Note

Without a model, the app will still compile and run, but voice recognition will not work. The app will show appropriate error messages when trying to use voice features.
