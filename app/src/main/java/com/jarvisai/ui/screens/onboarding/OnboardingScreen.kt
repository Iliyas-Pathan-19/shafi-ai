package com.jarvisai.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.jarvisai.ui.components.JarvisAvatar
import com.jarvisai.ui.screens.permissions.PermissionScreen
import com.jarvisai.utils.PermissionStatus

@Composable
fun OnboardingScreen(
    onOnboardingComplete: () -> Unit,
    permissionStatus: PermissionStatus? = null,
    onRequestPermissions: (() -> Unit)? = null,
    onRequestBatteryOptimization: (() -> Unit)? = null,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    
    // Check if we need to show permission screen first
    if (permissionStatus != null && !permissionStatus.hasMinimumPermissions) {
        PermissionScreen(
            permissionStatus = permissionStatus,
            onRequestPermissions = onRequestPermissions ?: { },
            onSkip = { /* Continue with limited functionality */ }
        )
        return
    }
    
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val allGranted = result.values.all { it }
        if (allGranted) {
            viewModel.onPermissionsGranted()
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        
        // Welcome Section
        JarvisAvatar()
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Welcome to JarvisAI",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Your personal voice assistant that respects your privacy",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        // Setup Steps
        when (uiState.currentStep) {
            OnboardingStep.Welcome -> WelcomeStep(
                onNext = { viewModel.nextStep() }
            )
            
            OnboardingStep.Permissions -> PermissionsStep(
                onRequestPermissions = {
                    permissionLauncher.launch(
                        arrayOf(
                            android.Manifest.permission.RECORD_AUDIO,
                            android.Manifest.permission.CALL_PHONE,
                            android.Manifest.permission.READ_CONTACTS,
                            android.Manifest.permission.POST_NOTIFICATIONS
                        )
                    )
                },
                onSkip = { viewModel.nextStep() }
            )
            
            OnboardingStep.AssistantSetup -> AssistantSetupStep(
                assistantName = uiState.assistantName,
                userNickname = uiState.userNickname,
                onAssistantNameChanged = viewModel::updateAssistantName,
                onUserNicknameChanged = viewModel::updateUserNickname,
                onNext = { viewModel.nextStep() }
            )
            
            OnboardingStep.VoiceSetup -> VoiceSetupStep(
                selectedVoice = uiState.selectedVoice,
                serEnabled = uiState.serEnabled,
                onVoiceSelected = viewModel::updateSelectedVoice,
                onSerToggled = viewModel::updateSerEnabled,
                onNext = { viewModel.nextStep() }
            )
            
            OnboardingStep.Complete -> CompleteStep(
                onComplete = {
                    viewModel.completeOnboarding()
                    onOnboardingComplete()
                }
            )
        }
    }
}

@Composable
private fun WelcomeStep(
    onNext: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        val features = listOf(
            "Always-on wake word detection",
            "Offline voice processing",
            "Smart device control",
            "Privacy-first design",
            "Emotion-aware responses"
        )
        
        features.forEach { feature ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "• $feature",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Started")
        }
    }
}

@Composable
private fun PermissionsStep(
    onRequestPermissions: () -> Unit,
    onSkip: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Permissions",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "JarvisAI needs these permissions to work properly:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        val permissions = listOf(
            "Microphone - For voice commands",
            "Phone - To make calls",
            "Contacts - To find contact info",
            "Notifications - For service status"
        )
        
        permissions.forEach { permission ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = permission,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onRequestPermissions,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Grant Permissions")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        TextButton(onClick = onSkip) {
            Text("Skip for now")
        }
    }
}


