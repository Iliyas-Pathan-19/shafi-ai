package com.jarvisai.data.di

import android.content.Context
// import com.jarvisai.data.dao.CommandHistoryDao
// import com.jarvisai.data.dao.UserPreferencesDao
import com.jarvisai.data.database.JarvisDatabase
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
    fun provideJarvisDatabase(@ApplicationContext context: Context): JarvisDatabase {
        return JarvisDatabase.getDatabase(context)
    }
    
    // Temporarily disabled due to Room being disabled
    // @Provides
    // fun provideCommandHistoryDao(database: JarvisDatabase): CommandHistoryDao {
    //     return database.commandHistoryDao()
    // }
    
    // @Provides
    // fun provideUserPreferencesDao(database: JarvisDatabase): UserPreferencesDao {
    //     return database.userPreferencesDao()
    // }
}
