package com.jarvisai.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.jarvisai.ui.components.JarvisAvatar
import com.jarvisai.ui.components.VoiceVisualization

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToSettings: () -> Unit,
    onNavigateToHistory: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        if (!uiState.isListening) {
            viewModel.toggleListening()
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top app bar with actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hey ${uiState.userNickname ?: "there"}!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            
            Row {
                IconButton(onClick = onNavigateToHistory) {
                    Icon(
                        imageVector = Icons.Default.History,
                        contentDescription = "History"
                    )
                }
                IconButton(onClick = onNavigateToSettings) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings"
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Assistant status and avatar
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = uiState.assistantName,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = uiState.statusMessage,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Main avatar
            JarvisAvatar(
                isListening = uiState.isListening,
                isProcessing = uiState.isProcessing
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Voice visualization
            VoiceVisualization(
                isActive = uiState.isListening || uiState.isProcessing,
                modifier = Modifier.height(24.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Control buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Manual toggle button
                FloatingActionButton(
                    onClick = { viewModel.toggleListening() },
                    containerColor = if (uiState.isListening) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.primary
                    }
                ) {
                    Icon(
                        imageVector = if (uiState.isListening) Icons.Default.MicOff else Icons.Default.Mic,
                        contentDescription = if (uiState.isListening) "Stop Listening" else "Start Listening"
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Quick command examples
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Try saying:",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.quickCommands) { command ->
                        Text(
                            text = "• $command",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Last command result
        if (uiState.lastCommandResult.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = uiState.lastCommandResult,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
