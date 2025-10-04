package com.jarvisai.ml.emotion;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/jarvisai/ml/emotion/TensorFlowEmotionAnalyzer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isModelLoaded", "", "analyzeEmotion", "Lcom/jarvisai/assistant/core/model/Emotion;", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateArousal", "", "emotion", "", "calculateDominance", "calculateValence", "generateMockEmotion", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "Companion", "ml_debug"})
public final class TensorFlowEmotionAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "TensorFlowEmotionAnalyzer";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MODEL_FILENAME = "emotion_model.tflite";
    private static final int INPUT_SIZE = 48;
    private static final int NUM_EMOTIONS = 7;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] EMOTION_LABELS = {"angry", "disgust", "fear", "happy", "sad", "surprised", "neutral"};
    private boolean isModelLoaded = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.ml.emotion.TensorFlowEmotionAnalyzer.Companion Companion = null;
    
    @javax.inject.Inject()
    public TensorFlowEmotionAnalyzer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object analyzeEmotion(@org.jetbrains.annotations.NotNull()
    short[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.model.Emotion> $completion) {
        return null;
    }
    
    private final float calculateValence(java.lang.String emotion) {
        return 0.0F;
    }
    
    private final float calculateArousal(java.lang.String emotion) {
        return 0.0F;
    }
    
    private final float calculateDominance(java.lang.String emotion) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.Emotion generateMockEmotion() {
        return null;
    }
    
    public final boolean isModelLoaded() {
        return false;
    }
    
    public final void release() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/jarvisai/ml/emotion/TensorFlowEmotionAnalyzer$Companion;", "", "()V", "EMOTION_LABELS", "", "", "[Ljava/lang/String;", "INPUT_SIZE", "", "MODEL_FILENAME", "NUM_EMOTIONS", "TAG", "ml_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}