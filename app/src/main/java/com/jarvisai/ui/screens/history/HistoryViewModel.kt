package com.jarvisai.ui.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarvisai.data.entity.CommandHistory
import com.jarvisai.data.repository.CommandHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HistoryUiState(
    val history: List<CommandHistory> = emptyList(),
    val isLoading: Boolean = true
)

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val commandHistoryRepository: CommandHistoryRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()
    
    init {
        observeHistory()
    }
    
    private fun observeHistory() {
        viewModelScope.launch {
            commandHistoryRepository.getAllHistory()
                .collect { history ->
                    _uiState.update {
                        it.copy(
                            history = history,
                            isLoading = false
                        )
                    }
                }
        }
    }
    
    fun deleteCommand(command: CommandHistory) {
        viewModelScope.launch {
            commandHistoryRepository.deleteCommand(command)
        }
    }
    
    fun clearAllHistory() {
        viewModelScope.launch {
            commandHistoryRepository.clearAllHistory()
        }
    }
}
