package com.jarvisai.assistant.core.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/jarvisai/assistant/core/di/VoiceModule;", "", "()V", "provideJarvisTTS", "Lcom/jarvisai/assistant/core/tts/JarvisTTS;", "context", "Landroid/content/Context;", "provideVoiceCloneRecorder", "Lcom/jarvisai/assistant/core/voice/VoiceCloneRecorder;", "provideVoskASR", "Lcom/jarvisai/assistant/core/asr/VoskASR;", "assistant-core_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class VoiceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.assistant.core.di.VoiceModule INSTANCE = null;
    
    private VoiceModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.asr.VoskASR provideVoskASR(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.tts.JarvisTTS provideJarvisTTS(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.assistant.core.voice.VoiceCloneRecorder provideVoiceCloneRecorder(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}