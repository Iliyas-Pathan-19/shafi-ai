package com.jarvisai.data.repository

import com.jarvisai.data.dao.UserPreferencesDao
import com.jarvisai.data.entity.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesRepository @Inject constructor(
    private val userPreferencesDao: UserPreferencesDao
) {
    
    fun getUserPreferences(): Flow<UserPreferences> = 
        userPreferencesDao.getUserPreferences().map { it ?: UserPreferences() }
    
    suspend fun initializePreferences() {
        val defaultPreferences = UserPreferences()
        userPreferencesDao.insertOrUpdatePreferences(defaultPreferences)
    }
    
    suspend fun updateAssistantName(name: String) = userPreferencesDao.updateAssistantName(name)
    
    suspend fun updateUserNickname(nickname: String?) = userPreferencesDao.updateUserNickname(nickname)
    
    suspend fun updateSelectedVoice(voice: String) = userPreferencesDao.updateSelectedVoice(voice)
    
    suspend fun updateSerEnabled(enabled: Boolean) = userPreferencesDao.updateSerEnabled(enabled)
    
    suspend fun updateBatterySaverEnabled(enabled: Boolean) = 
        userPreferencesDao.updateBatterySaverEnabled(enabled)
    
    suspend fun updateWakeWordSensitivity(sensitivity: Float) = 
        userPreferencesDao.updateWakeWordSensitivity(sensitivity)
    
    suspend fun updateVoiceClone(enabled: Boolean, path: String?) = 
        userPreferencesDao.updateVoiceClone(enabled, path)
    
    suspend fun updateAllPreferences(preferences: UserPreferences) = 
        userPreferencesDao.insertOrUpdatePreferences(preferences)

    suspend fun setOnboardingComplete(completed: Boolean) =
        userPreferencesDao.updateOnboardingComplete(completed)
}
