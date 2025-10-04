package com.jarvisai.ui.screens.onboarding

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

enum class OnboardingStep {
    Welcome, Permissions, AssistantSetup, VoiceSetup, Complete
}

data class OnboardingUiState(
    val currentStep: OnboardingStep = OnboardingStep.Welcome,
    val assistantName: String = "Jarvis",
    val userNickname: String = "",
    val selectedVoice: String = "default",
    val serEnabled: Boolean = true,
    val permissionsGranted: Boolean = false
)

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()
    
    fun nextStep() {
        val currentStep = _uiState.value.currentStep
        val nextStep = when (currentStep) {
            OnboardingStep.Welcome -> OnboardingStep.Permissions
            OnboardingStep.Permissions -> OnboardingStep.AssistantSetup
            OnboardingStep.AssistantSetup -> OnboardingStep.VoiceSetup
            OnboardingStep.VoiceSetup -> OnboardingStep.Complete
            OnboardingStep.Complete -> OnboardingStep.Complete
        }
        
        _uiState.update { it.copy(currentStep = nextStep) }
    }
    
    fun onPermissionsGranted() {
        _uiState.update { it.copy(permissionsGranted = true) }
        nextStep()
    }
    
    fun updateAssistantName(name: String) {
        _uiState.update { it.copy(assistantName = name) }
    }
    
    fun updateUserNickname(nickname: String) {
        _uiState.update { it.copy(userNickname = nickname) }
    }
    
    fun updateSelectedVoice(voice: String) {
        _uiState.update { it.copy(selectedVoice = voice) }
    }
    
    fun updateSerEnabled(enabled: Boolean) {
        _uiState.update { it.copy(serEnabled = enabled) }
    }
    
    fun completeOnboarding() {
        val state = _uiState.value
        
        viewModelScope.launch {
            try {
                userPreferencesRepository.updateAssistantName(state.assistantName)
                userPreferencesRepository.updateUserNickname(
                    state.userNickname.takeIf { it.isNotBlank() }
                )
                userPreferencesRepository.updateSelectedVoice(state.selectedVoice)
                userPreferencesRepository.updateSerEnabled(state.serEnabled)
                userPreferencesRepository.setOnboardingComplete(true)

                // Start the assistant foreground service immediately after onboarding
                val serviceIntent = Intent(appContext, VoiceAssistantService::class.java).apply {
                    action = VoiceAssistantService.ACTION_START_LISTENING
                }
                try {
                    androidx.core.content.ContextCompat.startForegroundService(appContext, serviceIntent)
                } catch (_: Exception) { }
            } catch (e: Exception) {
                // Handle error - in a real app, you might want to show an error message
                e.printStackTrace()
            }
        }
    }
}
