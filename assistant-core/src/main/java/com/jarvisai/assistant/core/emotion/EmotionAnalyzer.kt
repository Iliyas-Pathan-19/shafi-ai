package com.jarvisai.assistant.core.emotion

import com.jarvisai.assistant.core.model.EmotionResult

interface EmotionAnalyzer {
    fun isModelLoaded(): Boolean
    fun extractAudioFeatures(audioData: ShortArray): FloatArray
    fun classifyEmotion(audioFeatures: FloatArray): EmotionResult?
}


