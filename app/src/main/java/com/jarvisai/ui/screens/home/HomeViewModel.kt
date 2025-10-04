package com.jarvisai.ui.screens.home

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvisai.assistant.core.service.VoiceAssistantService
import com.jarvisai.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val assistantName: String = "Jarvis",
    val userNickname: String? = null,
    val isListening: Boolean = false,
    val isProcessing: Boolean = false,
    val statusMessage: String = "Ready to help",
    val lastCommandResult: String = "",
    val quickCommands: List<String> = listOf(
        "Hey Jarvis, call John",
        "Hey Jarvis, play some music",
        "Hey Jarvis, navigate to Central Park",
        "Hey Jarvis, send a message to Sarah",
        "Hey Jarvis, what's the weather like?",
        "Hey Jarvis, lock my screen"
    )
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    private var serviceIntent: Intent? = null
    
    init {
        observeUserPreferences()
        serviceIntent = Intent(context, VoiceAssistantService::class.java)
    }
    
    private fun observeUserPreferences() {
        viewModelScope.launch {
            userPreferencesRepository.getUserPreferences()
                .collect { preferences ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            assistantName = preferences.assistantName,
                            userNickname = preferences.userNickname,
                            quickCommands = currentState.quickCommands.map { command ->
                                command.replace("Jarvis", preferences.assistantName)
                            }
                        )
                    }
                }
        }
    }
    
    fun toggleListening() {
        val currentState = _uiState.value
        if (currentState.isListening) {
            stopListening()
        } else {
            startListening()
        }
    }
    
    private fun startListening() {
        try {
            val intent = serviceIntent?.apply {
                action = VoiceAssistantService.ACTION_START_LISTENING
            }
            intent?.let { context.startForegroundService(it) }
            
            _uiState.update { it.copy(
                isListening = true,
                statusMessage = "Listening for wake word...",
                lastCommandResult = ""
            )}
        } catch (e: Exception) {
            _uiState.update { it.copy(
                statusMessage = "Failed to start listening: ${e.message}",
                lastCommandResult = "Error: ${e.message}"
            )}
        }
    }
    
    private fun stopListening() {
        try {
            val intent = serviceIntent?.apply {
                action = VoiceAssistantService.ACTION_STOP_LISTENING
            }
            intent?.let { context.startService(it) }
            
            _uiState.update { it.copy(
                isListening = false,
                isProcessing = false,
                statusMessage = "Ready to help"
            )}
        } catch (e: Exception) {
            _uiState.update { it.copy(
                statusMessage = "Failed to stop listening: ${e.message}",
                lastCommandResult = "Error: ${e.message}"
            )}
        }
    }
    
    fun onWakeWordDetected() {
        _uiState.update { it.copy(
            isProcessing = true,
            statusMessage = "Listening for command..."
        )}
    }
    
    fun onCommandProcessed(result: String, success: Boolean) {
        _uiState.update { it.copy(
            isProcessing = false,
            statusMessage = if (success) "Command executed" else "Command failed",
            lastCommandResult = result
        )}
    }
    
    override fun onCleared() {
        super.onCleared()
        // Stop service when ViewModel is cleared
        stopListening()
    }
}
