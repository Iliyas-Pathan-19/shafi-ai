package com.jarvisai.assistant.core.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/jarvisai/assistant/core/model/EmotionResult;", "", "emotion", "Lcom/jarvisai/assistant/core/model/Emotion;", "confidence", "", "allScores", "", "(Lcom/jarvisai/assistant/core/model/Emotion;FLjava/util/Map;)V", "getAllScores", "()Ljava/util/Map;", "getConfidence", "()F", "getEmotion", "()Lcom/jarvisai/assistant/core/model/Emotion;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "assistant-core_debug"})
public final class EmotionResult {
    @org.jetbrains.annotations.NotNull()
    private final com.jarvisai.assistant.core.model.Emotion emotion = null;
    private final float confidence = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<com.jarvisai.assistant.core.model.Emotion, java.lang.Float> allScores = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.Emotion component1() {
        return null;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<com.jarvisai.assistant.core.model.Emotion, java.lang.Float> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.EmotionResult copy(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Emotion emotion, float confidence, @org.jetbrains.annotations.NotNull()
    java.util.Map<com.jarvisai.assistant.core.model.Emotion, java.lang.Float> allScores) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public EmotionResult(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.model.Emotion emotion, float confidence, @org.jetbrains.annotations.NotNull()
    java.util.Map<com.jarvisai.assistant.core.model.Emotion, java.lang.Float> allScores) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.Emotion getEmotion() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<com.jarvisai.assistant.core.model.Emotion, java.lang.Float> getAllScores() {
        return null;
    }
}