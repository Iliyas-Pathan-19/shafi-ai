package com.jarvisai.assistant.core.emotion;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;", "", "classifyEmotion", "Lcom/jarvisai/assistant/core/model/EmotionResult;", "audioFeatures", "", "extractAudioFeatures", "audioData", "", "isModelLoaded", "", "assistant-core_debug"})
public abstract interface EmotionAnalyzer {
    
    public abstract boolean isModelLoaded();
    
    @org.jetbrains.annotations.NotNull()
    public abstract float[] extractAudioFeatures(@org.jetbrains.annotations.NotNull()
    short[] audioData);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.jarvisai.assistant.core.model.EmotionResult classifyEmotion(@org.jetbrains.annotations.NotNull()
    float[] audioFeatures);
}