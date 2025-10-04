package com.jarvisai.data.repository

import com.jarvisai.data.dao.CommandHistoryDao
import com.jarvisai.data.entity.CommandHistory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommandHistoryRepository @Inject constructor(
    private val commandHistoryDao: CommandHistoryDao
) {
    
    fun getAllHistory(): Flow<List<CommandHistory>> = commandHistoryDao.getAllHistory()
    
    fun getSuccessfulCommands(limit: Int = 50): Flow<List<CommandHistory>> = 
        commandHistoryDao.getSuccessfulCommands(limit)
    
    fun getCommandsByEmotion(emotion: String): Flow<List<CommandHistory>> = 
        commandHistoryDao.getCommandsByEmotion(emotion)
    
    suspend fun insertCommand(
        command: String,
        transcript: String,
        response: String?,
        successful: Boolean,
        detectedEmotion: String? = null,
        confidence: Float? = null
    ) {
        val commandHistory = CommandHistory(
            command = command,
            transcript = transcript,
            response = response,
            executedAt = System.currentTimeMillis(),
            successful = successful,
            detectedEmotion = detectedEmotion,
            confidence = confidence
        )
        commandHistoryDao.insertCommand(commandHistory)
    }
    
    suspend fun deleteCommand(command: CommandHistory) = commandHistoryDao.deleteCommand(command)
    
    suspend fun clearAllHistory() = commandHistoryDao.clearAllHistory()
    
    suspend fun deleteOldCommands(olderThanDays: Int = 30) {
        val timestamp = System.currentTimeMillis() - (olderThanDays * 24 * 60 * 60 * 1000L)
        commandHistoryDao.deleteOldCommands(timestamp)
    }
    
    suspend fun getHistoryCount(): Int = commandHistoryDao.getHistoryCount()
}
