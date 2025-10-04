package com.jarvisai.assistant.core.emotion;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;", "", "analyzeEmotion", "Lcom/jarvisai/assistant/core/model/Emotion;", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyEmotion", "Lcom/jarvisai/assistant/core/model/EmotionResult;", "audioFeatures", "", "extractAudioFeatures", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isModelLoaded", "assistant-core_debug"})
public abstract interface EmotionAnalyzer {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    public abstract boolean isModelLoaded();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object analyzeEmotion(@org.jetbrains.annotations.NotNull()
    short[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.model.Emotion> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract float[] extractAudioFeatures(@org.jetbrains.annotations.NotNull()
    short[] audioData);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.jarvisai.assistant.core.model.EmotionResult classifyEmotion(@org.jetbrains.annotations.NotNull()
    float[] audioFeatures);
}