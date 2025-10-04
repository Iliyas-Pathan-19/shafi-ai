package com.jarvisai.assistant.core.tts;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u0002J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\'\u001a\u0004\u0018\u00010\nJ\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010-\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0014J\b\u00100\u001a\u000201H\u0002J\u000e\u00102\u001a\u000201H\u0096@\u00a2\u0006\u0002\u0010.J\b\u00103\u001a\u000201H\u0016J\u000e\u00104\u001a\u000201H\u0096@\u00a2\u0006\u0002\u0010.J\b\u00105\u001a\u000201H\u0002J\u0016\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u000208H\u0096@\u00a2\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020\u00142\u0006\u00107\u001a\u000208H\u0082@\u00a2\u0006\u0002\u00109J\u0016\u0010;\u001a\u00020\u00142\u0006\u00107\u001a\u000208H\u0082@\u00a2\u0006\u0002\u00109J\u000e\u0010<\u001a\u000201H\u0096@\u00a2\u0006\u0002\u0010.J\u0018\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060>*\u00020?H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/jarvisai/assistant/core/tts/JarvisTTS;", "Lcom/jarvisai/assistant/core/tts/TTSEngine;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "_availableVoices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/jarvisai/assistant/core/tts/TTSVoice;", "_state", "Lcom/jarvisai/assistant/core/tts/TTSState;", "audioTrack", "Landroid/media/AudioTrack;", "availableVoices", "Lkotlinx/coroutines/flow/Flow;", "getAvailableVoices", "()Lkotlinx/coroutines/flow/Flow;", "isInitialized", "", "state", "getState", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "voiceCloneDir", "Ljava/io/File;", "createVoiceClone", "name", "audioSamples", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createVoiceMetadata", "sampleFiles", "deleteVoiceClone", "voiceId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractNameFromMetadata", "metadata", "getClonedVoices", "getCurrentVoice", "getEmotionParameters", "Lkotlin/Pair;", "", "emotion", "getEngineInfo", "initialize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSpeaking", "loadAvailableVoices", "", "pause", "release", "resume", "setupTTS", "speak", "request", "Lcom/jarvisai/assistant/core/tts/TTSRequest;", "(Lcom/jarvisai/assistant/core/tts/TTSRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "speakWithClonedVoice", "speakWithSystemVoice", "stop", "toHashMap", "Ljava/util/HashMap;", "Landroid/os/Bundle;", "assistant-core_debug"})
public final class JarvisTTS implements com.jarvisai.assistant.core.tts.TTSEngine {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "JarvisTTS";
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech textToSpeech;
    @org.jetbrains.annotations.Nullable()
    private android.media.AudioTrack audioTrack;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.tts.TTSState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.tts.TTSState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.jarvisai.assistant.core.tts.TTSVoice>> _availableVoices = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.assistant.core.tts.TTSVoice>> availableVoices = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File voiceCloneDir = null;
    private boolean isInitialized = false;
    
    @javax.inject.Inject()
    public JarvisTTS(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.tts.TTSState> getState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.assistant.core.tts.TTSVoice>> getAvailableVoices() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final void setupTTS() {
    }
    
    private final void loadAvailableVoices() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object speak(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.tts.TTSRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.util.HashMap<java.lang.String, java.lang.String> toHashMap(android.os.Bundle $this$toHashMap) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Float, java.lang.Float> getEmotionParameters(java.lang.String emotion) {
        return null;
    }
    
    private final java.lang.Object speakWithClonedVoice(com.jarvisai.assistant.core.tts.TTSRequest request, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object speakWithSystemVoice(com.jarvisai.assistant.core.tts.TTSRequest request, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object stop(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object pause(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resume(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createVoiceClone(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> audioSamples, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.tts.TTSVoice> $completion) {
        return null;
    }
    
    private final java.lang.String createVoiceMetadata(java.lang.String name, java.util.List<? extends java.io.File> sampleFiles) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteVoiceClone(@org.jetbrains.annotations.NotNull()
    java.lang.String voiceId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.jarvisai.assistant.core.tts.TTSVoice> getClonedVoices() {
        return null;
    }
    
    private final java.lang.String extractNameFromMetadata(java.lang.String metadata) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jarvisai.assistant.core.tts.TTSVoice getCurrentVoice() {
        return null;
    }
    
    public final boolean isSpeaking() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEngineInfo() {
        return null;
    }
}