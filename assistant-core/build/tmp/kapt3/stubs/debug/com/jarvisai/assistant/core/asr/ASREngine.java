package com.jarvisai.assistant.core.asr;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H&J\u000e\u0010\u0013\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/jarvisai/assistant/core/asr/ASREngine;", "", "results", "Lkotlinx/coroutines/flow/Flow;", "Lcom/jarvisai/assistant/core/asr/ASRResult;", "getResults", "()Lkotlinx/coroutines/flow/Flow;", "state", "Lcom/jarvisai/assistant/core/asr/ASRState;", "getState", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAudioData", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "startListening", "stopListening", "assistant-core_debug"})
public abstract interface ASREngine {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRState> getState();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRResult> getResults();
    
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
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.asr.ASRResult> $completion);
    
    public abstract void release();
}