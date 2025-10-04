package com.jarvisai.ui.screens.permissions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jarvisai.utils.PermissionManager
import com.jarvisai.utils.PermissionStatus

@Composable
fun PermissionScreen(
    permissionStatus: PermissionStatus,
    onRequestPermissions: () -> Unit,
    onSkip: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        Icon(
            imageVector = Icons.Default.Security,
            contentDescription = "Permissions",
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Permissions Required",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "JarvisAI needs certain permissions to function properly. Please grant the required permissions to continue.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Required Permissions
        if (permissionStatus.missingRequired.isNotEmpty()) {
            PermissionSection(
                title = "Required Permissions",
                permissions = permissionStatus.missingRequired,
                isRequired = true
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        // Optional Permissions
        if (permissionStatus.missingOptional.isNotEmpty()) {
            PermissionSection(
                title = "Optional Permissions",
                permissions = permissionStatus.missingOptional,
                isRequired = false
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        // Notification Permission
        if (permissionStatus.missingNotification.isNotEmpty()) {
            PermissionSection(
                title = "Notification Permission",
                permissions = permissionStatus.missingNotification,
                isRequired = false
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
        
        // Action Buttons
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onRequestPermissions,
                modifier = Modifier.fillMaxWidth(),
                enabled = !permissionStatus.hasMinimumPermissions
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Grant Permissions")
            }
            
            if (permissionStatus.hasMinimumPermissions) {
                Text(
                    text = "All required permissions granted!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
            
            if (!permissionStatus.hasMinimumPermissions) {
                TextButton(
                    onClick = onSkip,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Skip for now (Limited functionality)")
                }
            }
        }
    }
}

@Composable
private fun PermissionSection(
    title: String,
    permissions: List<String>,
    isRequired: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (isRequired) 
                MaterialTheme.colorScheme.errorContainer 
            else 
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = if (isRequired) 
                    MaterialTheme.colorScheme.onErrorContainer 
                else 
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            permissions.forEach { permission ->
                PermissionItem(
                    permission = permission,
                    isRequired = isRequired
                )
                
                if (permission != permissions.last()) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun PermissionItem(
    permission: String,
    isRequired: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = getPermissionIcon(permission),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = if (isRequired) 
                MaterialTheme.colorScheme.onErrorContainer 
            else 
                MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.width(12.dp))
        
        Text(
            text = getPermissionDescription(permission),
            style = MaterialTheme.typography.bodyMedium,
            color = if (isRequired) 
                MaterialTheme.colorScheme.onErrorContainer 
            else 
                MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun getPermissionIcon(permission: String) = when {
    permission.contains("RECORD_AUDIO") -> Icons.Default.Mic
    permission.contains("CALL_PHONE") -> Icons.Default.Phone
    permission.contains("READ_CONTACTS") -> Icons.Default.Contacts
    permission.contains("SEND_SMS") -> Icons.Default.Message
    permission.contains("INTERNET") -> Icons.Default.Wifi
    permission.contains("WRITE_EXTERNAL_STORAGE") -> Icons.Default.Storage
    permission.contains("POST_NOTIFICATIONS") -> Icons.Default.Notifications
    else -> Icons.Default.Security
}

private fun getPermissionDescription(permission: String) = 
    PermissionManager.getPermissionRationale(permission)
