package com.jarvisai.data.dao

// Temporarily disabled due to Room being disabled
// import androidx.room.*
import com.jarvisai.data.entity.UserPreferences
import kotlinx.coroutines.flow.Flow

// @Dao
interface UserPreferencesDao {
    
    // @Query("SELECT * FROM user_preferences WHERE id = 1")
    fun getUserPreferences(): Flow<UserPreferences?>
    
    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdatePreferences(preferences: UserPreferences)
    
    // @Query("UPDATE user_preferences SET assistantName = :name WHERE id = 1")
    suspend fun updateAssistantName(name: String)
    
    // @Query("UPDATE user_preferences SET userNickname = :nickname WHERE id = 1")
    suspend fun updateUserNickname(nickname: String?)
    
    // @Query("UPDATE user_preferences SET selectedVoice = :voice WHERE id = 1")
    suspend fun updateSelectedVoice(voice: String)
    
    // @Query("UPDATE user_preferences SET isSerEnabled = :enabled WHERE id = 1")
    suspend fun updateSerEnabled(enabled: Boolean)
    
    // @Query("UPDATE user_preferences SET isBatterySaverEnabled = :enabled WHERE id = 1")
    suspend fun updateBatterySaverEnabled(enabled: Boolean)
    
    // @Query("UPDATE user_preferences SET wakeWordSensitivity = :sensitivity WHERE id = 1")
    suspend fun updateWakeWordSensitivity(sensitivity: Float)
    
    // @Query("UPDATE user_preferences SET voiceCloneEnabled = :enabled, voiceClonePath = :path WHERE id = 1")
    suspend fun updateVoiceClone(enabled: Boolean, path: String?)

    // @Query("UPDATE user_preferences SET isOnboardingComplete = :completed WHERE id = 1")
    suspend fun updateOnboardingComplete(completed: Boolean)
}
