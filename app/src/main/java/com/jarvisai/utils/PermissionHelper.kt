package com.jarvisai.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

object PermissionHelper {
    
    val REQUIRED_PERMISSIONS = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.POST_NOTIFICATIONS
        )
    } else {
        arrayOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS
        )
    }
    
    val OPTIONAL_PERMISSIONS = arrayOf(
        Manifest.permission.SEND_SMS,
        Manifest.permission.MODIFY_AUDIO_SETTINGS,
        Manifest.permission.ACCESS_NOTIFICATION_POLICY
    )
    
    fun hasPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }
    
    fun hasAllRequiredPermissions(context: Context): Boolean {
        return REQUIRED_PERMISSIONS.all { hasPermission(context, it) }
    }
    
    fun getMissingRequiredPermissions(context: Context): List<String> {
        return REQUIRED_PERMISSIONS.filter { !hasPermission(context, it) }
    }
    
    fun getMissingOptionalPermissions(context: Context): List<String> {
        return OPTIONAL_PERMISSIONS.filter { !hasPermission(context, it) }
    }
    
    fun getPermissionExplanation(permission: String): String {
        return when (permission) {
            Manifest.permission.RECORD_AUDIO -> "Microphone access is required for voice commands and wake word detection"
            Manifest.permission.CALL_PHONE -> "Phone permission is needed to make calls through voice commands"
            Manifest.permission.READ_CONTACTS -> "Contacts access allows you to call people by name"
            Manifest.permission.POST_NOTIFICATIONS -> "Notification permission is required for the assistant service status"
            Manifest.permission.SEND_SMS -> "SMS permission allows sending text messages through voice commands"
            Manifest.permission.MODIFY_AUDIO_SETTINGS -> "Audio settings permission allows volume control commands"
            Manifest.permission.ACCESS_NOTIFICATION_POLICY -> "Notification policy access enables Do Not Disturb control"
            else -> "This permission enhances JarvisAI functionality"
        }
    }
    
    fun isPermissionRequired(permission: String): Boolean {
        return permission in REQUIRED_PERMISSIONS
    }
}
