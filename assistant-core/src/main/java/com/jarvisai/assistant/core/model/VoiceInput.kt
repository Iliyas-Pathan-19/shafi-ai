package com.jarvisai.assistant.core.model

data class VoiceInput(
    val transcript: String,
    val confidence: Float,
    val detectedEmotion: Emotion? = null,
    val emotionConfidence: Float? = null,
    val timestamp: Long = System.currentTimeMillis()
)

enum class Emotion {
    NEUTRAL, HAPPY, SAD, ANGRY, SURPRISED, FRUSTRATED
}

data class EmotionResult(
    val emotion: Emotion,
    val confidence: Float,
    val allScores: Map<Emotion, Float>
)
