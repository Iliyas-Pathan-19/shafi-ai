package com.jarvisai.data.dao;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.*;
import com.jarvisai.data.entity.UserPreferences;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u00a6@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/jarvisai/data/dao/UserPreferencesDao;", "", "getUserPreferences", "Lkotlinx/coroutines/flow/Flow;", "Lcom/jarvisai/data/entity/UserPreferences;", "insertOrUpdatePreferences", "", "preferences", "(Lcom/jarvisai/data/entity/UserPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAssistantName", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBatterySaverEnabled", "enabled", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOnboardingComplete", "completed", "updateSelectedVoice", "voice", "updateSerEnabled", "updateUserNickname", "nickname", "updateVoiceClone", "path", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWakeWordSensitivity", "sensitivity", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface UserPreferencesDao {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.jarvisai.data.entity.UserPreferences> getUserPreferences();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrUpdatePreferences(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAssistantName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserNickname(@org.jetbrains.annotations.Nullable()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSelectedVoice(@org.jetbrains.annotations.NotNull()
    java.lang.String voice, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSerEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBatterySaverEnabled(boolean enabled, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWakeWordSensitivity(float sensitivity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateVoiceClone(boolean enabled, @org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateOnboardingComplete(boolean completed, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}