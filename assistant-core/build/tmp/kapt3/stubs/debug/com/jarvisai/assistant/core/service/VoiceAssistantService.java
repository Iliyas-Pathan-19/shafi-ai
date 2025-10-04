package com.jarvisai.assistant.core.service;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\n\b\u0007\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020?H\u0002J\u001a\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010D\u001a\u00020?H\u0002J\u000e\u0010E\u001a\u00020?H\u0082@\u00a2\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020?H\u0016J\b\u0010L\u001a\u00020?H\u0016J\"\u0010M\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0016J\u000e\u0010P\u001a\u00020?H\u0082@\u00a2\u0006\u0002\u0010FJ\u0016\u0010Q\u001a\u00020?2\u0006\u0010R\u001a\u00020SH\u0082@\u00a2\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020WH\u0002J\u000e\u0010X\u001a\u00020?H\u0082@\u00a2\u0006\u0002\u0010FJ\u0006\u0010Y\u001a\u00020?J\u0006\u0010Z\u001a\u00020?J\u0010\u0010[\u001a\u00020?2\u0006\u0010\\\u001a\u00020\u0004H\u0002J\u0010\u0010]\u001a\u00020?2\u0006\u0010^\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b \u0010\"R\u000e\u0010%\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\'8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040;X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lcom/jarvisai/assistant/core/service/VoiceAssistantService;", "Landroidx/lifecycle/LifecycleService;", "()V", "CHANNEL_ID", "", "NOTIFICATION_ID", "", "audioFormat", "audioRecord", "Landroid/media/AudioRecord;", "binder", "Lcom/jarvisai/assistant/core/service/VoiceAssistantService$VoiceAssistantBinder;", "bufferSize", "channelConfig", "commandHistoryRepository", "Lcom/jarvisai/data/repository/CommandHistoryRepository;", "getCommandHistoryRepository", "()Lcom/jarvisai/data/repository/CommandHistoryRepository;", "setCommandHistoryRepository", "(Lcom/jarvisai/data/repository/CommandHistoryRepository;)V", "emotionClassifier", "Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;", "getEmotionClassifier", "()Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;", "setEmotionClassifier", "(Lcom/jarvisai/assistant/core/emotion/EmotionAnalyzer;)V", "intentParser", "Lcom/jarvisai/assistant/core/parser/IntentParser;", "getIntentParser", "()Lcom/jarvisai/assistant/core/parser/IntentParser;", "setIntentParser", "(Lcom/jarvisai/assistant/core/parser/IntentParser;)V", "isDebug", "", "()Z", "isDebug$delegate", "Lkotlin/Lazy;", "isListening", "jarvisTTS", "Lcom/jarvisai/assistant/core/tts/JarvisTTS;", "getJarvisTTS", "()Lcom/jarvisai/assistant/core/tts/JarvisTTS;", "setJarvisTTS", "(Lcom/jarvisai/assistant/core/tts/JarvisTTS;)V", "sampleRate", "userPreferencesRepository", "Lcom/jarvisai/data/repository/UserPreferencesRepository;", "getUserPreferencesRepository", "()Lcom/jarvisai/data/repository/UserPreferencesRepository;", "setUserPreferencesRepository", "(Lcom/jarvisai/data/repository/UserPreferencesRepository;)V", "voskASR", "Lcom/jarvisai/assistant/core/asr/VoskASR;", "getVoskASR", "()Lcom/jarvisai/assistant/core/asr/VoskASR;", "setVoskASR", "(Lcom/jarvisai/assistant/core/asr/VoskASR;)V", "wakeWordDetected", "wakeWords", "", "createNotification", "Landroid/app/Notification;", "createNotificationChannel", "", "generateResponse", "command", "Lcom/jarvisai/assistant/core/model/Command;", "emotion", "handleWakeWordDetected", "initializeVoiceComponents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "processAudioStream", "processVoiceCommand", "voiceInput", "Lcom/jarvisai/assistant/core/model/VoiceInput;", "(Lcom/jarvisai/assistant/core/model/VoiceInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "simulateWakeWordDetection", "audioBuffer", "", "startCommandListening", "startListening", "stopListening", "updateNotification", "text", "updateWakeWords", "assistantName", "Companion", "VoiceAssistantBinder", "assistant-core_debug"})
public final class VoiceAssistantService extends androidx.lifecycle.LifecycleService {
    @javax.inject.Inject()
    public com.jarvisai.assistant.core.parser.IntentParser intentParser;
    @javax.inject.Inject()
    public com.jarvisai.data.repository.CommandHistoryRepository commandHistoryRepository;
    @javax.inject.Inject()
    public com.jarvisai.data.repository.UserPreferencesRepository userPreferencesRepository;
    @javax.inject.Inject()
    public com.jarvisai.assistant.core.asr.VoskASR voskASR;
    @javax.inject.Inject()
    public com.jarvisai.assistant.core.tts.JarvisTTS jarvisTTS;
    @javax.inject.Inject()
    public com.jarvisai.assistant.core.emotion.EmotionAnalyzer emotionClassifier;
    @org.jetbrains.annotations.Nullable()
    private android.media.AudioRecord audioRecord;
    private boolean isListening = false;
    private boolean wakeWordDetected = false;
    @org.jetbrains.annotations.NotNull()
    private final com.jarvisai.assistant.core.service.VoiceAssistantService.VoiceAssistantBinder binder = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isDebug$delegate = null;
    private final int sampleRate = 16000;
    private final int channelConfig = android.media.AudioFormat.CHANNEL_IN_MONO;
    private final int audioFormat = android.media.AudioFormat.ENCODING_PCM_16BIT;
    private final int bufferSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CHANNEL_ID = "VOICE_ASSISTANT_CHANNEL";
    private final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> wakeWords = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_START_LISTENING = "com.jarvisai.START_LISTENING";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_STOP_LISTENING = "com.jarvisai.STOP_LISTENING";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_WAKE_WORD_DETECTED = "com.jarvisai.WAKE_WORD_DETECTED";
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.assistant.core.service.VoiceAssistantService.Companion Companion = null;
    
    public VoiceAssistantService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.parser.IntentParser getIntentParser() {
        return null;
    }
    
    public final void setIntentParser(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.parser.IntentParser p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.data.repository.CommandHistoryRepository getCommandHistoryRepository() {
        return null;
    }
    
    public final void setCommandHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.repository.CommandHistoryRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.data.repository.UserPreferencesRepository getUserPreferencesRepository() {
        return null;
    }
    
    public final void setUserPreferencesRepository(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.repository.UserPreferencesRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.asr.VoskASR getVoskASR() {
        return null;
    }
    
    public final void setVoskASR(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.asr.VoskASR p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.tts.JarvisTTS getJarvisTTS() {
        return null;
    }
    
    public final void setJarvisTTS(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.tts.JarvisTTS p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.emotion.EmotionAnalyzer getEmotionClassifier() {
        return null;
    }
    
    public final void setEmotionClassifier(@org.jetbrains.annotations.NotNull()
    com.jarvisai.assistant.core.emotion.EmotionAnalyzer p0) {
    }
    
    private final boolean isDebug() {
        return false;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final java.lang.Object initializeVoiceComponents(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void updateWakeWords(java.lang.String assistantName) {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    private final android.app.Notification createNotification() {
        return null;
    }
    
    private final void updateNotification(java.lang.String text) {
    }
    
    public final void startListening() {
    }
    
    public final void stopListening() {
    }
    
    private final java.lang.Object processAudioStream(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean simulateWakeWordDetection(short[] audioBuffer) {
        return false;
    }
    
    private final void handleWakeWordDetected() {
    }
    
    private final java.lang.Object startCommandListening(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object processVoiceCommand(com.jarvisai.assistant.core.model.VoiceInput voiceInput, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String generateResponse(com.jarvisai.assistant.core.model.Command command, java.lang.String emotion) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/jarvisai/assistant/core/service/VoiceAssistantService$Companion;", "", "()V", "ACTION_START_LISTENING", "", "ACTION_STOP_LISTENING", "ACTION_WAKE_WORD_DETECTED", "assistant-core_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/jarvisai/assistant/core/service/VoiceAssistantService$VoiceAssistantBinder;", "Landroid/os/Binder;", "(Lcom/jarvisai/assistant/core/service/VoiceAssistantService;)V", "getService", "Lcom/jarvisai/assistant/core/service/VoiceAssistantService;", "assistant-core_debug"})
    public final class VoiceAssistantBinder extends android.os.Binder {
        
        public VoiceAssistantBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jarvisai.assistant.core.service.VoiceAssistantService getService() {
            return null;
        }
    }
}