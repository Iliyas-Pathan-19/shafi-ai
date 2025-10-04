package com.jarvisai.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvisai.data.repository.CommandHistoryRepository
import com.jarvisai.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val assistantName: String = "Jarvis",
    val userNickname: String = "",
    val selectedVoice: String = "default",
    val serEnabled: Boolean = true,
    val batterySaverEnabled: Boolean = false,
    val wakeWordSensitivity: Float = 0.5f,
    val voiceCloneEnabled: Boolean = false
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository,
    private val commandHistoryRepository: CommandHistoryRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()
    
    init {
        observeUserPreferences()
    }
    
    private fun observeUserPreferences() {
        viewModelScope.launch {
            userPreferencesRepository.getUserPreferences()
                .collect { preferences ->
                    _uiState.update {
                        SettingsUiState(
                            assistantName = preferences.assistantName,
                            userNickname = preferences.userNickname ?: "",
                            selectedVoice = preferences.selectedVoice,
                            serEnabled = preferences.isSerEnabled,
                            batterySaverEnabled = preferences.isBatterySaverEnabled,
                            wakeWordSensitivity = preferences.wakeWordSensitivity,
                            voiceCloneEnabled = preferences.voiceCloneEnabled
                        )
                    }
                }
        }
    }
    
    fun updateAssistantName(name: String) {
        _uiState.update { it.copy(assistantName = name) }
        viewModelScope.launch {
            userPreferencesRepository.updateAssistantName(name)
        }
    }
    
    fun updateUserNickname(nickname: String) {
        _uiState.update { it.copy(userNickname = nickname) }
        viewModelScope.launch {
            userPreferencesRepository.updateUserNickname(
                nickname.takeIf { it.isNotBlank() }
            )
        }
    }
    
    fun updateSelectedVoice(voice: String) {
        _uiState.update { it.copy(selectedVoice = voice) }
        viewModelScope.launch {
            userPreferencesRepository.updateSelectedVoice(voice)
        }
    }
    
    fun updateSerEnabled(enabled: Boolean) {
        _uiState.update { it.copy(serEnabled = enabled) }
        viewModelScope.launch {
            userPreferencesRepository.updateSerEnabled(enabled)
        }
    }
    
    fun updateBatterySaverEnabled(enabled: Boolean) {
        _uiState.update { it.copy(batterySaverEnabled = enabled) }
        viewModelScope.launch {
            userPreferencesRepository.updateBatterySaverEnabled(enabled)
        }
    }
    
    fun updateWakeWordSensitivity(sensitivity: Float) {
        _uiState.update { it.copy(wakeWordSensitivity = sensitivity) }
        viewModelScope.launch {
            userPreferencesRepository.updateWakeWordSensitivity(sensitivity)
        }
    }
    
    fun updateVoiceCloneEnabled(enabled: Boolean) {
        _uiState.update { it.copy(voiceCloneEnabled = enabled) }
        viewModelScope.launch {
            userPreferencesRepository.updateVoiceClone(enabled, null)
        }
    }
    
    fun clearHistory() {
        viewModelScope.launch {
            commandHistoryRepository.clearAllHistory()
        }
    }
}
