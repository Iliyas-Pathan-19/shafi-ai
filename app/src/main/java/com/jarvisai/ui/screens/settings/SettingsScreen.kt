package com.jarvisai.ui.screens.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    onNavigateToVoiceClone: () -> Unit = {},
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top App Bar
        TopAppBar(
            title = { Text("Settings") },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        
        // Settings Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Assistant Configuration
            SettingsSection(title = "Assistant") {
                SettingsTextField(
                    label = "Assistant Name",
                    value = uiState.assistantName,
                    onValueChange = viewModel::updateAssistantName,
                    placeholder = "Jarvis"
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                SettingsTextField(
                    label = "Your Nickname",
                    value = uiState.userNickname,
                    onValueChange = viewModel::updateUserNickname,
                    placeholder = "How should I address you?"
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Voice Settings
            SettingsSection(title = "Voice") {
                Text(
                    text = "Voice Selection",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Medium
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                val voiceOptions = listOf(
                    "default" to "System Default",
                    "male" to "Male Voice",
                    "female" to "Female Voice"
                )
                
                voiceOptions.forEach { (value, label) ->
                    SettingsRadioOption(
                        text = label,
                        selected = uiState.selectedVoice == value,
                        onClick = { viewModel.updateSelectedVoice(value) }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Voice Cloning",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "Create and manage your custom voice",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    OutlinedButton(
                        onClick = onNavigateToVoiceClone
                    ) {
                        Text("Manage")
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // AI Features
            SettingsSection(title = "AI Features") {
                SettingsSwitch(
                    title = "Emotion Recognition",
                    subtitle = "Adapt responses based on your tone",
                    checked = uiState.serEnabled,
                    onCheckedChange = viewModel::updateSerEnabled
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                SettingsSwitch(
                    title = "Battery Saver Mode",
                    subtitle = "Reduce background processing",
                    checked = uiState.batterySaverEnabled,
                    onCheckedChange = viewModel::updateBatterySaverEnabled
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Wake Word Sensitivity",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Medium
                )
                
                Slider(
                    value = uiState.wakeWordSensitivity,
                    onValueChange = viewModel::updateWakeWordSensitivity,
                    valueRange = 0f..1f,
                    steps = 9
                )
                
                Text(
                    text = "Sensitivity: ${(uiState.wakeWordSensitivity * 100).toInt()}%",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Privacy & Data
            SettingsSection(title = "Privacy & Data") {
                Button(
                    onClick = viewModel::clearHistory,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Clear All History")
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "This will permanently delete all stored commands and interactions.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // App Info
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "JarvisAI",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Version 1.0.0",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Privacy-first voice assistant for Android",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
private fun SettingsTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = ""
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun SettingsSwitch(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun SettingsRadioOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
