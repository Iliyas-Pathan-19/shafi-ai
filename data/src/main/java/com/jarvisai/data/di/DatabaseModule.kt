package com.jarvisai.data.di

import android.content.Context
import com.jarvisai.data.dao.CommandHistoryDao
import com.jarvisai.data.dao.CommandHistoryDaoImpl
import com.jarvisai.data.dao.UserPreferencesDao
import com.jarvisai.data.dao.UserPreferencesDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideCommandHistoryDao(): CommandHistoryDao {
        return CommandHistoryDaoImpl()
    }
    
    @Provides
    @Singleton
    fun provideUserPreferencesDao(@ApplicationContext context: Context): UserPreferencesDao {
        return UserPreferencesDaoImpl(context)
    }
}
