package com.jarvisai.assistant.core.asr;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u0004\u0018\u00010%H\u0082@\u00a2\u0006\u0002\u0010\u001eJ\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u0006\u0010,\u001a\u00020\u0012J\u001a\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0012H\u0002J\u0018\u00100\u001a\u0004\u0018\u00010\u000b2\u0006\u00101\u001a\u000202H\u0096@\u00a2\u0006\u0002\u00103J\u0010\u00104\u001a\u0004\u0018\u000105H\u0082@\u00a2\u0006\u0002\u0010\u001eJ\b\u00106\u001a\u00020 H\u0016J\u000e\u00107\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u000e\u00108\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006:"}, d2 = {"Lcom/jarvisai/assistant/core/asr/VoskASR;", "Lcom/jarvisai/assistant/core/asr/ASREngine;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SAMPLE_RATE", "", "TAG", "", "_results", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/jarvisai/assistant/core/asr/ASRResult;", "_state", "Lcom/jarvisai/assistant/core/asr/ASRState;", "audioBuffer", "", "", "isListening", "", "model", "Lorg/vosk/Model;", "recognizer", "Lorg/vosk/Recognizer;", "results", "Lkotlinx/coroutines/flow/Flow;", "getResults", "()Lkotlinx/coroutines/flow/Flow;", "state", "getState", "downloadModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAssetFile", "", "assetManager", "Landroid/content/res/AssetManager;", "assetPath", "destFile", "Ljava/io/File;", "extractAssetFolder", "fromAssetPath", "toDir", "extractModelFromAssets", "getModelInfo", "initialize", "isModelAvailable", "parseResult", "jsonResult", "isFinal", "processAudioData", "audioData", "", "([SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processFinalAudio", "", "release", "startListening", "stopListening", "Companion", "assistant-core_debug"})
public final class VoskASR implements com.jarvisai.assistant.core.asr.ASREngine {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "VoskASR";
    private final int SAMPLE_RATE = 16000;
    @org.jetbrains.annotations.Nullable()
    private org.vosk.Model model;
    @org.jetbrains.annotations.Nullable()
    private org.vosk.Recognizer recognizer;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.asr.ASRState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.asr.ASRResult> _results = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRResult> results = null;
    private boolean isListening = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Short> audioBuffer;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODEL_NAME = "vosk-model-small-en-us-0.15";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MODEL_ASSET_PATH = "vosk-models/vosk-model-small-en-us-0.15";
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.assistant.core.asr.VoskASR.Companion Companion = null;
    
    @javax.inject.Inject()
    public VoskASR(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRState> getState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.asr.ASRResult> getResults() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object extractModelFromAssets(kotlin.coroutines.Continuation<? super java.io.File> $completion) {
        return null;
    }
    
    private final void extractAssetFolder(android.content.res.AssetManager assetManager, java.lang.String fromAssetPath, java.io.File toDir) {
    }
    
    private final void extractAssetFile(android.content.res.AssetManager assetManager, java.lang.String assetPath, java.io.File destFile) {
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
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.asr.ASRResult> $completion) {
        return null;
    }
    
    private final java.lang.Object processFinalAudio(kotlin.coroutines.Continuation<java.lang.Object> $completion) {
        return null;
    }
    
    private final com.jarvisai.assistant.core.asr.ASRResult parseResult(java.lang.String jsonResult, boolean isFinal) {
        return null;
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    public final boolean isModelAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object downloadModel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelInfo() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/jarvisai/assistant/core/asr/VoskASR$Companion;", "", "()V", "MODEL_ASSET_PATH", "", "MODEL_NAME", "assistant-core_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}