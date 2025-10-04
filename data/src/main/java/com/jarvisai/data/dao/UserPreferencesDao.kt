package com.jarvisai.data.dao

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.jarvisai.data.entity.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

interface UserPreferencesDao {
    fun getUserPreferences(): Flow<UserPreferences?>
    suspend fun insertOrUpdatePreferences(preferences: UserPreferences)
    suspend fun updateAssistantName(name: String)
    suspend fun updateUserNickname(nickname: String?)
    suspend fun updateSelectedVoice(voice: String)
    suspend fun updateSerEnabled(enabled: Boolean)
    suspend fun updateBatterySaverEnabled(enabled: Boolean)
    suspend fun updateWakeWordSensitivity(sensitivity: Float)
    suspend fun updateVoiceClone(enabled: Boolean, path: String?)
    suspend fun updateOnboardingComplete(completed: Boolean)
}

@Singleton
class UserPreferencesDaoImpl @Inject constructor(
    private val context: Context
) : UserPreferencesDao {
    
    private val dataStore = context.dataStore
    
    private object PreferencesKeys {
        val ASSISTANT_NAME = stringPreferencesKey("assistant_name")
        val USER_NICKNAME = stringPreferencesKey("user_nickname")
        val SELECTED_VOICE = stringPreferencesKey("selected_voice")
        val IS_SER_ENABLED = booleanPreferencesKey("is_ser_enabled")
        val IS_BATTERY_SAVER_ENABLED = booleanPreferencesKey("is_battery_saver_enabled")
        val WAKE_WORD_SENSITIVITY = floatPreferencesKey("wake_word_sensitivity")
        val VOICE_CLONE_ENABLED = booleanPreferencesKey("voice_clone_enabled")
        val VOICE_CLONE_PATH = stringPreferencesKey("voice_clone_path")
        val IS_ONBOARDING_COMPLETE = booleanPreferencesKey("is_onboarding_complete")
    }
    
    override fun getUserPreferences(): Flow<UserPreferences?> = dataStore.data.map { preferences ->
        UserPreferences(
            assistantName = preferences[PreferencesKeys.ASSISTANT_NAME] ?: "Jarvis",
            userNickname = preferences[PreferencesKeys.USER_NICKNAME],
            selectedVoice = preferences[PreferencesKeys.SELECTED_VOICE] ?: "default",
            isSerEnabled = preferences[PreferencesKeys.IS_SER_ENABLED] ?: true,
            isBatterySaverEnabled = preferences[PreferencesKeys.IS_BATTERY_SAVER_ENABLED] ?: false,
            wakeWordSensitivity = preferences[PreferencesKeys.WAKE_WORD_SENSITIVITY] ?: 0.5f,
            voiceCloneEnabled = preferences[PreferencesKeys.VOICE_CLONE_ENABLED] ?: false,
            voiceClonePath = preferences[PreferencesKeys.VOICE_CLONE_PATH],
            isOnboardingComplete = preferences[PreferencesKeys.IS_ONBOARDING_COMPLETE] ?: false
        )
    }
    
    override suspend fun insertOrUpdatePreferences(preferences: UserPreferences) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.ASSISTANT_NAME] = preferences.assistantName
            prefs[PreferencesKeys.USER_NICKNAME] = preferences.userNickname ?: ""
            prefs[PreferencesKeys.SELECTED_VOICE] = preferences.selectedVoice
            prefs[PreferencesKeys.IS_SER_ENABLED] = preferences.isSerEnabled
            prefs[PreferencesKeys.IS_BATTERY_SAVER_ENABLED] = preferences.isBatterySaverEnabled
            prefs[PreferencesKeys.WAKE_WORD_SENSITIVITY] = preferences.wakeWordSensitivity
            prefs[PreferencesKeys.VOICE_CLONE_ENABLED] = preferences.voiceCloneEnabled
            prefs[PreferencesKeys.VOICE_CLONE_PATH] = preferences.voiceClonePath ?: ""
            prefs[PreferencesKeys.IS_ONBOARDING_COMPLETE] = preferences.isOnboardingComplete
        }
    }
    
    override suspend fun updateAssistantName(name: String) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.ASSISTANT_NAME] = name
        }
    }
    
    override suspend fun updateUserNickname(nickname: String?) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.USER_NICKNAME] = nickname ?: ""
        }
    }
    
    override suspend fun updateSelectedVoice(voice: String) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.SELECTED_VOICE] = voice
        }
    }
    
    override suspend fun updateSerEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.IS_SER_ENABLED] = enabled
        }
    }
    
    override suspend fun updateBatterySaverEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.IS_BATTERY_SAVER_ENABLED] = enabled
        }
    }
    
    override suspend fun updateWakeWordSensitivity(sensitivity: Float) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.WAKE_WORD_SENSITIVITY] = sensitivity
        }
    }
    
    override suspend fun updateVoiceClone(enabled: Boolean, path: String?) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.VOICE_CLONE_ENABLED] = enabled
            prefs[PreferencesKeys.VOICE_CLONE_PATH] = path ?: ""
        }
    }
    
    override suspend fun updateOnboardingComplete(completed: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.IS_ONBOARDING_COMPLETE] = completed
        }
    }
}
