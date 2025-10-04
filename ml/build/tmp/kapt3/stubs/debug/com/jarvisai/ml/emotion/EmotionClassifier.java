package com.jarvisai.ml.emotion;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/jarvisai/ml/emotion/EmotionClassifier;", "Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "emotionLabels", "", "Lcom/jarvisai/assistant/core/model/Emotion;", "[Lcom/jarvisai/assistant/core/model/Emotion;", "inputSize", "", "outputSize", "analyzeEmotion", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyEmotion", "Lcom/jarvisai/assistant/core/model/EmotionResult;", "audioFeatures", "", "close", "", "extractAudioFeatures", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isModelLoaded", "loadModel", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "filename", "", "ml_debug"})
public final class EmotionClassifier implements com.jarvisai.assistant.core.emotion.EmotionAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final int inputSize = 1024;
    private final int outputSize = 6;
    @org.jetbrains.annotations.NotNull()
    private final com.jarvisai.assistant.core.model.Emotion[] emotionLabels = {com.jarvisai.assistant.core.model.Emotion.NEUTRAL, com.jarvisai.assistant.core.model.Emotion.HAPPY, com.jarvisai.assistant.core.model.Emotion.SAD, com.jarvisai.assistant.core.model.Emotion.ANGRY, com.jarvisai.assistant.core.model.Emotion.SURPRISED, com.jarvisai.assistant.core.model.Emotion.FRUSTRATED};
    
    @javax.inject.Inject()
    public EmotionClassifier(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final void loadModel() {
    }
    
    private final java.nio.MappedByteBuffer loadModelFile(java.lang.String filename) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.jarvisai.assistant.core.model.EmotionResult classifyEmotion(@org.jetbrains.annotations.NotNull()
    float[] audioFeatures) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public float[] extractAudioFeatures(@org.jetbrains.annotations.NotNull()
    short[] audioData) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object analyzeEmotion(@org.jetbrains.annotations.NotNull()
    short[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.model.Emotion> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isModelLoaded() {
        return false;
    }
    
    public final void close() {
    }
}