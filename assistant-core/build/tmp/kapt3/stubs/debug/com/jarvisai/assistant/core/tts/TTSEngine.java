package com.jarvisai.assistant.core.tts;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u000e\u0010\u0016\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u00a6@\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u0019H&J\u000e\u0010\u001b\u001a\u00020\u0019H\u00a6@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u00a6@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0019H\u00a6@\u00a2\u0006\u0002\u0010\u0017R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0007\u00a8\u0006!"}, d2 = {"Lcom/jarvisai/assistant/core/tts/TTSEngine;", "", "availableVoices", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/jarvisai/assistant/core/tts/TTSVoice;", "getAvailableVoices", "()Lkotlinx/coroutines/flow/Flow;", "state", "Lcom/jarvisai/assistant/core/tts/TTSState;", "getState", "createVoiceClone", "name", "", "audioSamples", "Ljava/io/File;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVoiceClone", "", "voiceId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClonedVoices", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "", "release", "resume", "speak", "request", "Lcom/jarvisai/assistant/core/tts/TTSRequest;", "(Lcom/jarvisai/assistant/core/tts/TTSRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "assistant-core_debug"})
public abstract interface TTSEngine {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.tts.TTSState> getState();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.assistant.core.tts.TTSVoice>> getAvailableVoices();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object speak(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.tts.TTSRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object stop(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object pause(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resume(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    public abstract void release();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createVoiceClone(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> audioSamples, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.tts.TTSVoice> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteVoiceClone(@org.jetbrains.annotations.NotNull()
    java.lang.String voiceId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.jarvisai.assistant.core.tts.TTSVoice> getClonedVoices();
}