package com.jarvisai.data.di;

import android.content.Context;
import com.jarvisai.data.dao.CommandHistoryDao;
import com.jarvisai.data.dao.CommandHistoryDaoImpl;
import com.jarvisai.data.dao.UserPreferencesDao;
import com.jarvisai.data.dao.UserPreferencesDaoImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/jarvisai/data/di/DatabaseModule;", "", "()V", "provideCommandHistoryDao", "Lcom/jarvisai/data/dao/CommandHistoryDao;", "provideUserPreferencesDao", "Lcom/jarvisai/data/dao/UserPreferencesDao;", "context", "Landroid/content/Context;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.jarvisai.data.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.data.dao.CommandHistoryDao provideCommandHistoryDao() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.jarvisai.data.dao.UserPreferencesDao provideUserPreferencesDao(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}