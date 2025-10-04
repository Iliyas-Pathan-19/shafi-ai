package com.jarvisai.data.repository;

import com.jarvisai.data.dao.CommandHistoryDao;
import com.jarvisai.data.entity.CommandHistory;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u0011J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u000eJH\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0086@\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/jarvisai/data/repository/CommandHistoryRepository;", "", "commandHistoryDao", "Lcom/jarvisai/data/dao/CommandHistoryDao;", "(Lcom/jarvisai/data/dao/CommandHistoryDao;)V", "clearAllHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCommand", "command", "Lcom/jarvisai/data/entity/CommandHistory;", "(Lcom/jarvisai/data/entity/CommandHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldCommands", "olderThanDays", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHistory", "Lkotlinx/coroutines/flow/Flow;", "", "getCommandsByEmotion", "emotion", "", "getHistoryCount", "getSuccessfulCommands", "limit", "insertCommand", "transcript", "response", "successful", "", "detectedEmotion", "confidence", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Float;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CommandHistoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.jarvisai.data.dao.CommandHistoryDao commandHistoryDao = null;
    
    @javax.inject.Inject()
    public CommandHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.dao.CommandHistoryDao commandHistoryDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getAllHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getSuccessfulCommands(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getCommandsByEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String emotion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertCommand(@org.jetbrains.annotations.NotNull()
    java.lang.String command, @org.jetbrains.annotations.NotNull()
    java.lang.String transcript, @org.jetbrains.annotations.Nullable()
    java.lang.String response, boolean successful, @org.jetbrains.annotations.Nullable()
    java.lang.String detectedEmotion, @org.jetbrains.annotations.Nullable()
    java.lang.Float confidence, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCommand(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.CommandHistory command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAllHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteOldCommands(int olderThanDays, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
}