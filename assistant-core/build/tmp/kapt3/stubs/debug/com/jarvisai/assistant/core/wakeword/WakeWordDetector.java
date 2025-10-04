package com.jarvisai.assistant.core.wakeword;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\t\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\u000e\u0010\u0015\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0016\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\nR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/jarvisai/assistant/core/wakeword/WakeWordDetector;", "", "detectionResults", "Lkotlinx/coroutines/flow/Flow;", "Lcom/jarvisai/assistant/core/wakeword/WakeWordDetectionResult;", "getDetectionResults", "()Lkotlinx/coroutines/flow/Flow;", "isListening", "", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAudioData", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "setWakeWords", "wakeWords", "", "", "startListening", "stopListening", "assistant-core_debug"})
public abstract interface WakeWordDetector {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isListening();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> getDetectionResults();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startListening(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object stopListening(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object processAudioData(@org.jetbrains.annotations.NotNull()
    short[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> $completion);
    
    public abstract void release();
    
    public abstract void setWakeWords(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> wakeWords);
}