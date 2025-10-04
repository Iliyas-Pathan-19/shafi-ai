package com.jarvisai.assistant.core.voice;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010#J\b\u0010$\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010%\u001a\u00020&J\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001aJ\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\b\u0010+\u001a\u00020 H\u0002J\u0018\u0010,\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001cH\u0002J\u000e\u0010.\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010#J\u0018\u0010/\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u00101J\u0010\u00102\u001a\u0004\u0018\u00010\u001cH\u0086@\u00a2\u0006\u0002\u0010#J\u0018\u00103\u001a\u00020\"2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/jarvisai/assistant/core/voice/VoiceCloneRecorder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "AUDIO_FORMAT", "", "BUFFER_SIZE", "CHANNEL_CONFIG", "SAMPLE_RATE", "TAG", "", "_currentSession", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/jarvisai/assistant/core/voice/VoiceCloneSession;", "_recordingState", "Lcom/jarvisai/assistant/core/voice/RecordingState;", "audioRecord", "Landroid/media/AudioRecord;", "currentSession", "Lkotlinx/coroutines/flow/Flow;", "getCurrentSession", "()Lkotlinx/coroutines/flow/Flow;", "recordingState", "getRecordingState", "trainingPrompts", "", "voiceCloneDir", "Ljava/io/File;", "analyzeAudioQuality", "Lcom/jarvisai/assistant/core/voice/AudioQualityMetrics;", "audioData", "", "cancelSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentSentence", "getProgress", "", "getSessionSamples", "hasActiveSession", "", "isSessionComplete", "readAudioData", "saveAsWav", "outputFile", "startRecording", "startVoiceCloneSession", "userName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "writeWavHeader", "fos", "Ljava/io/FileOutputStream;", "audioDataSize", "assistant-core_debug"})
public final class VoiceCloneRecorder {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "VoiceCloneRecorder";
    private final int SAMPLE_RATE = 22050;
    private final int CHANNEL_CONFIG = android.media.AudioFormat.CHANNEL_IN_MONO;
    private final int AUDIO_FORMAT = android.media.AudioFormat.ENCODING_PCM_16BIT;
    private final int BUFFER_SIZE = 0;
    @org.jetbrains.annotations.Nullable()
    private android.media.AudioRecord audioRecord;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.voice.RecordingState> _recordingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.voice.RecordingState> recordingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.jarvisai.assistant.core.voice.VoiceCloneSession> _currentSession = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.voice.VoiceCloneSession> currentSession = null;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File voiceCloneDir = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> trainingPrompts = null;
    
    @javax.inject.Inject()
    public VoiceCloneRecorder(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.voice.RecordingState> getRecordingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.jarvisai.assistant.core.voice.VoiceCloneSession> getCurrentSession() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startVoiceCloneSession(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.jarvisai.assistant.core.voice.VoiceCloneSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startRecording(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object stopRecording(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.io.File> $completion) {
        return null;
    }
    
    private final short[] readAudioData() {
        return null;
    }
    
    private final void saveAsWav(short[] audioData, java.io.File outputFile) {
    }
    
    private final void writeWavHeader(java.io.FileOutputStream fos, int audioDataSize) {
    }
    
    private final com.jarvisai.assistant.core.voice.AudioQualityMetrics analyzeAudioQuality(short[] audioData) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentSentence() {
        return null;
    }
    
    public final float getProgress() {
        return 0.0F;
    }
    
    public final boolean isSessionComplete() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.io.File> getSessionSamples() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cancelSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final boolean hasActiveSession() {
        return false;
    }
}