package com.jarvisai.data.dao;

import com.jarvisai.data.entity.CommandHistory;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000eH&J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u000e\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0014H&J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/jarvisai/data/dao/CommandHistoryDao;", "", "clearAllHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCommand", "command", "Lcom/jarvisai/data/entity/CommandHistory;", "(Lcom/jarvisai/data/entity/CommandHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldCommands", "timestamp", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHistory", "Lkotlinx/coroutines/flow/Flow;", "", "getCommandsByEmotion", "emotion", "", "getHistoryCount", "", "getSuccessfulCommands", "limit", "insertCommand", "data_debug"})
public abstract interface CommandHistoryDao {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getAllHistory();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getSuccessfulCommands(int limit);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getCommandsByEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String emotion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCommand(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.CommandHistory command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCommand(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.CommandHistory command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAllHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldCommands(long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}