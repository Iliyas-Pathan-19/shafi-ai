package com.jarvisai.data.dao

// Temporarily disabled due to Room being disabled
// import androidx.room.*
import com.jarvisai.data.entity.CommandHistory
import kotlinx.coroutines.flow.Flow

// @Dao
interface CommandHistoryDao {
    
    // @Query("SELECT * FROM command_history ORDER BY executedAt DESC")
    fun getAllHistory(): Flow<List<CommandHistory>>
    
    // @Query("SELECT * FROM command_history WHERE successful = 1 ORDER BY executedAt DESC LIMIT :limit")
    fun getSuccessfulCommands(limit: Int = 50): Flow<List<CommandHistory>>
    
    // @Query("SELECT * FROM command_history WHERE detectedEmotion = :emotion ORDER BY executedAt DESC")
    fun getCommandsByEmotion(emotion: String): Flow<List<CommandHistory>>
    
    // @Insert
    suspend fun insertCommand(command: CommandHistory)
    
    // @Delete
    suspend fun deleteCommand(command: CommandHistory)
    
    // @Query("DELETE FROM command_history")
    suspend fun clearAllHistory()
    
    // @Query("DELETE FROM command_history WHERE executedAt < :timestamp")
    suspend fun deleteOldCommands(timestamp: Long)
    
    // @Query("SELECT COUNT(*) FROM command_history")
    suspend fun getHistoryCount(): Int
}
