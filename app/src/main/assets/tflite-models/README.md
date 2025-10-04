# TensorFlow Lite Models for JarvisAI

This directory contains TensorFlow Lite models for on-device machine learning features.

## Required Models

### Emotion Recognition Model
- **File**: `emotion_model.tflite`
- **Purpose**: Speech emotion recognition from audio data
- **Input**: 48x48 audio features (flattened to 2304 features)
- **Output**: 7 emotion probabilities (angry, disgust, fear, happy, sad, surprised, neutral)
- **Source**: FER2013 dataset trained model

### How to Add Models

1. **Download or train your TensorFlow Lite model**
2. **Place the `.tflite` file in this directory**
3. **Update the model filename in `TensorFlowEmotionAnalyzer.kt` if needed**
4. **Test the model loading in the app**

## Model Sources

### Emotion Recognition
- **Recommended**: Use a pre-trained model from TensorFlow Hub
- **Training**: FER2013 dataset with audio feature extraction
- **Format**: TensorFlow Lite (.tflite)
- **Size**: Should be < 10MB for mobile deployment

## Testing Without Models

The app includes mock implementations that will work without actual model files:
- Mock emotion analysis with random emotions
- Mock wake word detection
- All features work in "simulation mode"

## Performance Notes

- Models are loaded asynchronously on app startup
- GPU acceleration is enabled if available
- Fallback to CPU if GPU is not available
- Models are cached in memory for fast inference

## Troubleshooting

If models fail to load:
1. Check file permissions
2. Verify model format (must be .tflite)
3. Check model input/output dimensions
4. Review logs for specific error messages
