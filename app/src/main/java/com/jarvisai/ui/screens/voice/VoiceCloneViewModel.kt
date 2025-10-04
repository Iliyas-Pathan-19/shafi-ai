package com.jarvisai.ui.screens.voice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvisai.assistant.core.tts.JarvisTTS
import com.jarvisai.assistant.core.tts.TTSVoice
import com.jarvisai.assistant.core.voice.RecordingState
import com.jarvisai.assistant.core.voice.VoiceCloneRecorder
import com.jarvisai.assistant.core.voice.VoiceCloneSession
import com.jarvisai.data.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VoiceCloneUiState(
    val clonedVoices: List<TTSVoice> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class VoiceCloneViewModel @Inject constructor(
    private val voiceCloneRecorder: VoiceCloneRecorder,
    private val jarvisTTS: JarvisTTS,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(VoiceCloneUiState())
    val uiState: StateFlow<VoiceCloneUiState> = _uiState.asStateFlow()
    
    val recordingState: StateFlow<RecordingState> = voiceCloneRecorder.recordingState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RecordingState.Idle
    )
    
    val currentSession: StateFlow<VoiceCloneSession?> = voiceCloneRecorder.currentSession.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )
    
    init {
        loadClonedVoices()
    }
    
    private fun loadClonedVoices() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                
                val clonedVoices = jarvisTTS.getClonedVoices()
                
                _uiState.update {
                    it.copy(
                        clonedVoices = clonedVoices,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Failed to load voice clones: ${e.message}"
                    )
                }
            }
        }
    }
    
    fun startCloneSession(voiceName: String) {
        viewModelScope.launch {
            try {
                val session = voiceCloneRecorder.startVoiceCloneSession(voiceName)
                if (session == null) {
                    _uiState.update {
                        it.copy(error = "Failed to start voice cloning session")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Error starting session: ${e.message}")
                }
            }
        }
    }
    
    fun startRecording() {
        viewModelScope.launch {
            try {
                val success = voiceCloneRecorder.startRecording()
                if (!success) {
                    _uiState.update {
                        it.copy(error = "Failed to start recording")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Recording error: ${e.message}")
                }
            }
        }
    }
    
    fun stopRecording() {
        viewModelScope.launch {
            try {
                val audioFile = voiceCloneRecorder.stopRecording()
                if (audioFile == null) {
                    _uiState.update {
                        it.copy(error = "Failed to save recording")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Stop recording error: ${e.message}")
                }
            }
        }
    }
    
    fun completeSession() {
        viewModelScope.launch {
            try {
                val session = currentSession.value
                if (session != null && session.isComplete) {
                    // Create the voice clone
                    val voiceClone = jarvisTTS.createVoiceClone(
                        name = "Custom Voice ${System.currentTimeMillis()}",
                        audioSamples = session.recordedSamples
                    )
                    
                    if (voiceClone != null) {
                        // Update voice preferences to use the new clone
                        userPreferencesRepository.updateSelectedVoice(voiceClone.id)
                        userPreferencesRepository.updateVoiceClone(true, voiceClone.clonePath)
                        
                        // Refresh the list
                        loadClonedVoices()
                        
                        _uiState.update {
                            it.copy(error = null)
                        }
                    } else {
                        _uiState.update {
                            it.copy(error = "Failed to create voice clone")
                        }
                    }
                }
                
                // End the session
                voiceCloneRecorder.cancelSession()
                
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Session completion error: ${e.message}")
                }
            }
        }
    }
    
    fun cancelSession() {
        viewModelScope.launch {
            try {
                voiceCloneRecorder.cancelSession()
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Cancel error: ${e.message}")
                }
            }
        }
    }
    
    fun deleteVoiceClone(voiceId: String) {
        viewModelScope.launch {
            try {
                val success = jarvisTTS.deleteVoiceClone(voiceId)
                if (success) {
                    loadClonedVoices()
                    _uiState.update {
                        it.copy(error = null)
                    }
                } else {
                    _uiState.update {
                        it.copy(error = "Failed to delete voice clone")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = "Delete error: ${e.message}")
                }
            }
        }
    }
    
    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}
