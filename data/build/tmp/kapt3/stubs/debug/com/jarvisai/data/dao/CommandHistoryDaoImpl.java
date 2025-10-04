package com.jarvisai.data.dao;

import com.jarvisai.data.entity.CommandHistory;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00122\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/jarvisai/data/dao/CommandHistoryDaoImpl;", "Lcom/jarvisai/data/dao/CommandHistoryDao;", "()V", "_history", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/jarvisai/data/entity/CommandHistory;", "clearAllHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCommand", "command", "(Lcom/jarvisai/data/entity/CommandHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldCommands", "timestamp", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHistory", "Lkotlinx/coroutines/flow/Flow;", "getCommandsByEmotion", "emotion", "", "getHistoryCount", "", "getSuccessfulCommands", "limit", "insertCommand", "data_debug"})
public final class CommandHistoryDaoImpl implements com.jarvisai.data.dao.CommandHistoryDao {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.jarvisai.data.entity.CommandHistory>> _history = null;
    
    @javax.inject.Inject()
    public CommandHistoryDaoImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getAllHistory() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getSuccessfulCommands(int limit) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.jarvisai.data.entity.CommandHistory>> getCommandsByEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String emotion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertCommand(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.CommandHistory command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteCommand(@org.jetbrains.annotations.NotNull()
    com.jarvisai.data.entity.CommandHistory command, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearAllHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteOldCommands(long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getHistoryCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
}