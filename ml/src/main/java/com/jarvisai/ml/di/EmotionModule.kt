package com.jarvisai.ml.di

import com.jarvisai.assistant.core.emotion.EmotionAnalyzer
import com.jarvisai.ml.emotion.EmotionClassifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EmotionModule {
    @Binds
    abstract fun bindEmotionAnalyzer(impl: EmotionClassifier): EmotionAnalyzer
}


