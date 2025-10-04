package com.jarvisai.assistant.core.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/jarvisai/assistant/core/model/VoiceInput;", "", "transcript", "", "confidence", "", "detectedEmotion", "Lcom/jarvisai/assistant/core/model/Emotion;", "emotionConfidence", "timestamp", "", "(Ljava/lang/String;FLcom/jarvisai/assistant/core/model/Emotion;Ljava/lang/Float;J)V", "getConfidence", "()F", "getDetectedEmotion", "()Lcom/jarvisai/assistant/core/model/Emotion;", "getEmotionConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTimestamp", "()J", "getTranscript", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;FLcom/jarvisai/assistant/core/model/Emotion;Ljava/lang/Float;J)Lcom/jarvisai/assistant/core/model/VoiceInput;", "equals", "", "other", "hashCode", "", "toString", "assistant-core_debug"})
public final class VoiceInput {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String transcript = null;
    private final float confidence = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final com.jarvisai.assistant.core.model.Emotion detectedEmotion = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float emotionConfidence = null;
    private final long timestamp = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jarvisai.assistant.core.model.Emotion component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.model.VoiceInput copy(@org.jetbrains.annotations.NotNull()
    java.lang.String transcript, float confidence, @org.jetbrains.annotations.Nullable()
    com.jarvisai.assistant.core.model.Emotion detectedEmotion, @org.jetbrains.annotations.Nullable()
    java.lang.Float emotionConfidence, long timestamp) {
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
    
    public VoiceInput(@org.jetbrains.annotations.NotNull()
    java.lang.String transcript, float confidence, @org.jetbrains.annotations.Nullable()
    com.jarvisai.assistant.core.model.Emotion detectedEmotion, @org.jetbrains.annotations.Nullable()
    java.lang.Float emotionConfidence, long timestamp) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTranscript() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jarvisai.assistant.core.model.Emotion getDetectedEmotion() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getEmotionConfidence() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
}