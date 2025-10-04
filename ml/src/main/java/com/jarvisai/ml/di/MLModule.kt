package com.jarvisai.ml.di

import android.content.Context
import com.jarvisai.ml.emotion.EmotionClassifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MLModule {
    
    @Provides
    @Singleton
    fun provideEmotionClassifier(@ApplicationContext context: Context): EmotionClassifier {
        return EmotionClassifier(context)
    }
}
