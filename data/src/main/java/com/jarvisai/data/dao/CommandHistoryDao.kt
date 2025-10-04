package com.jarvisai.data.dao

import com.jarvisai.data.entity.CommandHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

interface CommandHistoryDao {
    fun getAllHistory(): Flow<List<CommandHistory>>
    fun getSuccessfulCommands(limit: Int = 50): Flow<List<CommandHistory>>
    fun getCommandsByEmotion(emotion: String): Flow<List<CommandHistory>>
    suspend fun insertCommand(command: CommandHistory)
    suspend fun deleteCommand(command: CommandHistory)
    suspend fun clearAllHistory()
    suspend fun deleteOldCommands(timestamp: Long)
    suspend fun getHistoryCount(): Int
}

@Singleton
class CommandHistoryDaoImpl @Inject constructor() : CommandHistoryDao {
    
    private val _history = MutableStateFlow<List<CommandHistory>>(emptyList())
    
    override fun getAllHistory(): Flow<List<CommandHistory>> = _history.asStateFlow()
    
    override fun getSuccessfulCommands(limit: Int): Flow<List<CommandHistory>> = 
        _history.asStateFlow().map { history ->
            history.filter { it.successful }.take(limit)
        }
    
    override fun getCommandsByEmotion(emotion: String): Flow<List<CommandHistory>> = 
        _history.asStateFlow().map { history ->
            history.filter { it.detectedEmotion == emotion }
        }
    
    override suspend fun insertCommand(command: CommandHistory) {
        val currentHistory = _history.value.toMutableList()
        currentHistory.add(0, command) // Add to beginning for newest first
        _history.value = currentHistory
    }
    
    override suspend fun deleteCommand(command: CommandHistory) {
        val currentHistory = _history.value.toMutableList()
        currentHistory.remove(command)
        _history.value = currentHistory
    }
    
    override suspend fun clearAllHistory() {
        _history.value = emptyList()
    }
    
    override suspend fun deleteOldCommands(timestamp: Long) {
        val currentHistory = _history.value.toMutableList()
        currentHistory.removeAll { it.executedAt < timestamp }
        _history.value = currentHistory
    }
    
    override suspend fun getHistoryCount(): Int = _history.value.size
}
