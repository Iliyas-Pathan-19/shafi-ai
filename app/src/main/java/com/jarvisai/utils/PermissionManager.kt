package com.jarvisai.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.jarvisai.R

object PermissionManager {
    
    // Required permissions for the app to function
    val REQUIRED_PERMISSIONS = arrayOf(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.WAKE_LOCK,
        Manifest.permission.MODIFY_AUDIO_SETTINGS
    )
    
    // Optional permissions for enhanced functionality
    val OPTIONAL_PERMISSIONS = arrayOf(
        Manifest.permission.CALL_PHONE,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.SEND_SMS,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    
    // Android 13+ notification permission
    val NOTIFICATION_PERMISSION = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(Manifest.permission.POST_NOTIFICATIONS)
    } else {
        emptyArray()
    }
    
    fun checkAllPermissions(context: Context): PermissionStatus {
        val missingRequired = REQUIRED_PERMISSIONS.filter { permission ->
            ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
        }
        
        val missingOptional = OPTIONAL_PERMISSIONS.filter { permission ->
            ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
        }
        
        val missingNotification = NOTIFICATION_PERMISSION.filter { permission ->
            ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
        }
        
        return PermissionStatus(
            hasAllRequired = missingRequired.isEmpty(),
            hasAllOptional = missingOptional.isEmpty(),
            hasNotification = missingNotification.isEmpty(),
            missingRequired = missingRequired,
            missingOptional = missingOptional,
            missingNotification = missingNotification
        )
    }
    
    fun createPermissionLauncher(
        activity: FragmentActivity,
        onResult: (PermissionStatus) -> Unit
    ): ActivityResultLauncher<Array<String>> {
        return activity.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            val status = checkAllPermissions(activity)
            onResult(status)
        }
    }
    
    fun requestRequiredPermissions(
        activity: FragmentActivity,
        launcher: ActivityResultLauncher<Array<String>>
    ) {
        val status = checkAllPermissions(activity)
        if (!status.hasAllRequired) {
            launcher.launch(status.missingRequired.toTypedArray())
        }
    }
    
    fun requestOptionalPermissions(
        activity: FragmentActivity,
        launcher: ActivityResultLauncher<Array<String>>
    ) {
        val status = checkAllPermissions(activity)
        if (!status.hasAllOptional) {
            launcher.launch(status.missingOptional.toTypedArray())
        }
    }
    
    fun requestNotificationPermission(
        activity: FragmentActivity,
        launcher: ActivityResultLauncher<Array<String>>
    ) {
        val status = checkAllPermissions(activity)
        if (!status.hasNotification) {
            launcher.launch(status.missingNotification.toTypedArray())
        }
    }
    
    fun getPermissionRationale(permission: String): String {
        return when (permission) {
            Manifest.permission.RECORD_AUDIO -> "Microphone access is required for voice commands and speech recognition."
            Manifest.permission.CALL_PHONE -> "Phone access is required to make calls when requested."
            Manifest.permission.READ_CONTACTS -> "Contact access is required to call people by name."
            Manifest.permission.SEND_SMS -> "SMS access is required to send messages when requested."
            Manifest.permission.INTERNET -> "Internet access is required for cloud features and research."
            Manifest.permission.WRITE_EXTERNAL_STORAGE -> "Storage access is required to save voice recordings and data."
            Manifest.permission.POST_NOTIFICATIONS -> "Notification permission is required for the assistant to show status updates."
            else -> "This permission is required for the assistant to function properly."
        }
    }
}

data class PermissionStatus(
    val hasAllRequired: Boolean,
    val hasAllOptional: Boolean,
    val hasNotification: Boolean,
    val missingRequired: List<String>,
    val missingOptional: List<String>,
    val missingNotification: List<String>
) {
    val hasMinimumPermissions: Boolean
        get() = hasAllRequired
}
