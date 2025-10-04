package com.jarvisai.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AssistantSetupStep(
    assistantName: String,
    userNickname: String,
    onAssistantNameChanged: (String) -> Unit,
    onUserNicknameChanged: (String) -> Unit,
    onNext: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Personalization",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        OutlinedTextField(
            value = assistantName,
            onValueChange = onAssistantNameChanged,
            label = { Text("Assistant Name") },
            placeholder = { Text("Jarvis") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = userNickname,
            onValueChange = onUserNicknameChanged,
            label = { Text("Your Nickname (Optional)") },
            placeholder = { Text("How should I address you?") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "You can say \"Hey ${assistantName.ifEmpty { "Jarvis" }}\" to activate the assistant",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun VoiceSetupStep(
    selectedVoice: String,
    serEnabled: Boolean,
    onVoiceSelected: (String) -> Unit,
    onSerToggled: (Boolean) -> Unit,
    onNext: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Voice Settings",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Voice Selection
        Text(
            text = "Select Voice",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Column(
            modifier = Modifier.selectableGroup()
        ) {
            val voiceOptions = listOf(
                "default" to "System Default",
                "male" to "Male Voice",
                "female" to "Female Voice"
            )
            
            voiceOptions.forEach { (value, label) ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedVoice == value),
                            onClick = { onVoiceSelected(value) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedVoice == value),
                        onClick = null
                    )
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Emotion Recognition Toggle
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
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
                            text = "Emotion Recognition",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Adapt responses based on your tone",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    Switch(
                        checked = serEnabled,
                        onCheckedChange = onSerToggled
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}

@Composable
fun CompleteStep(
    onComplete: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "All Set!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "JarvisAI is ready to help. You can start by saying your wake word or tapping the microphone button.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onComplete,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Using JarvisAI")
        }
    }
}
