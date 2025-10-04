package com.jarvisai.assistant.core.wakeword;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J\u000e\u0010\u001d\u001a\u00020\u001bH\u0096@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u001e\u001a\u00020\u001bH\u0096@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/jarvisai/assistant/core/wakeword/PorcupineWakeWordDetector;", "Lcom/jarvisai/assistant/core/wakeword/WakeWordDetector;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "_detectionResults", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/jarvisai/assistant/core/wakeword/WakeWordDetectionResult;", "_isListening", "", "detectionResults", "Lkotlinx/coroutines/flow/Flow;", "getDetectionResults", "()Lkotlinx/coroutines/flow/Flow;", "isInitialized", "isListening", "wakeWords", "", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAudioData", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "setWakeWords", "startListening", "stopListening", "assistant-core_debug"})
public final class PorcupineWakeWordDetector implements com.jarvisai.assistant.core.wakeword.WakeWordDetector {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "PorcupineWakeWordDetector";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isListening = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isListening = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> _detectionResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> detectionResults = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> wakeWords;
    private boolean isInitialized = false;
    
    @javax.inject.Inject()
    public PorcupineWakeWordDetector(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isListening() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> getDetectionResults() {
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
    public java.lang.Object startListening(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object stopListening(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object processAudioData(@org.jetbrains.annotations.NotNull()
    short[] audioData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.wakeword.WakeWordDetectionResult> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    @java.lang.Override()
    public void setWakeWords(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> wakeWords) {
    }
}