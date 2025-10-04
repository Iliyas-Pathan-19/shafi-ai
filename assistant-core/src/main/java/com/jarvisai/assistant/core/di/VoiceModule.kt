package com.jarvisai.assistant.core.di

import android.content.Context
import com.jarvisai.assistant.core.asr.VoskASR
import com.jarvisai.assistant.core.tts.JarvisTTS
import com.jarvisai.assistant.core.voice.VoiceCloneRecorder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VoiceModule {
    
    @Provides
    @Singleton
    fun provideVoskASR(@ApplicationContext context: Context): VoskASR {
        return VoskASR(context)
    }
    
    @Provides
    @Singleton
    fun provideJarvisTTS(@ApplicationContext context: Context): JarvisTTS {
        return JarvisTTS(context)
    }
    
    @Provides
    @Singleton
    fun provideVoiceCloneRecorder(@ApplicationContext context: Context): VoiceCloneRecorder {
        return VoiceCloneRecorder(context)
    }
}
