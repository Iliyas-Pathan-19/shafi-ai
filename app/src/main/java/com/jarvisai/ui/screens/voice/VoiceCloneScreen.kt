package com.jarvisai.ui.screens.voice

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoiceCloneScreen(
    onNavigateBack: () -> Unit,
    viewModel: VoiceCloneViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val recordingState by viewModel.recordingState.collectAsState()
    val session by viewModel.currentSession.collectAsState()
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("Voice Cloning") },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            actions = {
                if (session != null) {
                    IconButton(
                        onClick = { viewModel.cancelSession() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cancel Session"
                        )
                    }
                }
            }
        )
        
        // Content
        val currentSession = session
        when {
            currentSession == null -> {
                // No active session - show clone list and start option
                VoiceCloneMainScreen(
                    uiState = uiState,
                    onStartCloning = viewModel::startCloneSession,
                    onDeleteClone = viewModel::deleteVoiceClone
                )
            }
            else -> {
                // Active session - show recording interface
                VoiceCloneRecordingScreen(
                    session = currentSession,
                    recordingState = recordingState,
                    onStartRecording = viewModel::startRecording,
                    onStopRecording = viewModel::stopRecording,
                    onCompleteSession = viewModel::completeSession
                )
            }
        }
    }
}

@Composable
private fun VoiceCloneMainScreen(
    uiState: VoiceCloneUiState,
    onStartCloning: (String) -> Unit,
    onDeleteClone: (String) -> Unit
) {
    var showCreateDialog by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Introduction
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Voice Cloning",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Create a personalized voice for your assistant by recording a few sentences. This process is completely private and stored locally on your device.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Create new voice clone button
        Button(
            onClick = { showCreateDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Create New Voice Clone")
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Existing voice clones
        if (uiState.clonedVoices.isNotEmpty()) {
            Text(
                text = "Your Voice Clones",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.clonedVoices) { voice ->
                    VoiceCloneItem(
                        voice = voice,
                        onDelete = { onDeleteClone(voice.id) }
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No voice clones created yet",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
    
    // Create dialog
    if (showCreateDialog) {
        CreateVoiceCloneDialog(
            onDismiss = { showCreateDialog = false },
            onConfirm = { name ->
                onStartCloning(name)
                showCreateDialog = false
            }
        )
    }
}

@Composable
private fun VoiceCloneItem(
    voice: com.jarvisai.assistant.core.tts.TTSVoice,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = voice.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Quality: ${voice.quality}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Voice Clone",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun VoiceCloneRecordingScreen(
    session: com.jarvisai.assistant.core.voice.VoiceCloneSession,
    recordingState: com.jarvisai.assistant.core.voice.RecordingState,
    onStartRecording: () -> Unit,
    onStopRecording: () -> Unit,
    onCompleteSession: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Progress indicator
        LinearProgressIndicator(
            progress = session.currentSentenceIndex.toFloat() / session.targetSentences.size.toFloat(),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Recording ${session.currentSentenceIndex + 1} of ${session.targetSentences.size}",
            style = MaterialTheme.typography.titleMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Current sentence to read
        if (session.currentSentenceIndex < session.targetSentences.size) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = session.targetSentences[session.currentSentenceIndex],
                    modifier = Modifier.padding(24.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Instructions
            Text(
                text = when (recordingState) {
                    is com.jarvisai.assistant.core.voice.RecordingState.Idle -> "Tap the microphone to start recording"
                    is com.jarvisai.assistant.core.voice.RecordingState.Recording -> "Recording... Speak clearly and naturally"
                    is com.jarvisai.assistant.core.voice.RecordingState.Processing -> "Processing your recording..."
                    is com.jarvisai.assistant.core.voice.RecordingState.Error -> "Error: ${recordingState.message}"
                    else -> "Preparing..."
                },
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = if (recordingState is com.jarvisai.assistant.core.voice.RecordingState.Error) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Recording button
            FloatingActionButton(
                onClick = {
                    when (recordingState) {
                        is com.jarvisai.assistant.core.voice.RecordingState.Idle -> onStartRecording()
                        is com.jarvisai.assistant.core.voice.RecordingState.Recording -> onStopRecording()
                        else -> { /* Do nothing */ }
                    }
                },
                modifier = Modifier.size(80.dp),
                containerColor = when (recordingState) {
                    is com.jarvisai.assistant.core.voice.RecordingState.Recording -> MaterialTheme.colorScheme.error
                    else -> MaterialTheme.colorScheme.primary
                }
            ) {
                Icon(
                    imageVector = when (recordingState) {
                        is com.jarvisai.assistant.core.voice.RecordingState.Recording -> Icons.Default.Stop
                        else -> Icons.Default.Mic
                    },
                    contentDescription = when (recordingState) {
                        is com.jarvisai.assistant.core.voice.RecordingState.Recording -> "Stop Recording"
                        else -> "Start Recording"
                    },
                    modifier = Modifier.size(40.dp)
                )
            }
            
        } else {
            // Session complete
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = "Recording Complete!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Your voice clone is being processed and will be available in the voice settings.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(
                        onClick = onCompleteSession,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Complete")
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateVoiceCloneDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var voiceName by remember { mutableStateOf("") }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Create Voice Clone") },
        text = {
            Column {
                Text(
                    text = "Give your voice clone a name:",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = voiceName,
                    onValueChange = { voiceName = it },
                    label = { Text("Voice Name") },
                    placeholder = { Text("My Voice") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(voiceName) },
                enabled = voiceName.isNotBlank()
            ) {
                Text("Start Recording")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
