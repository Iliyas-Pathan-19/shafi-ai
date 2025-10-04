package com.jarvisai.deviceactions.handler

import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import android.provider.Settings
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import com.jarvisai.assistant.core.model.DeviceActionType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SystemActionHandler @Inject constructor(
    private val context: Context
) {
    
    private val audioManager: AudioManager by lazy {
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }
    
    fun handleDeviceAction(command: Command.DeviceAction): CommandResult {
        return when (command.action) {
            DeviceActionType.LOCK_SCREEN -> lockScreen()
            DeviceActionType.UNLOCK_SCREEN -> unlockScreen()
            DeviceActionType.TURN_ON_WIFI -> toggleWifi(true)
            DeviceActionType.TURN_OFF_WIFI -> toggleWifi(false)
            DeviceActionType.TURN_ON_BLUETOOTH -> toggleBluetooth(true)
            DeviceActionType.TURN_OFF_BLUETOOTH -> toggleBluetooth(false)
            DeviceActionType.INCREASE_VOLUME -> adjustVolume(true)
            DeviceActionType.DECREASE_VOLUME -> adjustVolume(false)
            DeviceActionType.MUTE_VOLUME -> muteVolume()
            DeviceActionType.TAKE_SCREENSHOT -> takeScreenshot()
        }
    }
    
    private fun lockScreen(): CommandResult {
        return try {
            // Method 1: Try device admin approach (requires device admin permissions)
            val devicePolicyManager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            
            // Without a DeviceAdminReceiver ComponentName we cannot query isAdminActive(null).
            // Fallback directly to settings approach.
            val canLockDirectly = false
            if (canLockDirectly) {
                devicePolicyManager.lockNow()
                CommandResult(
                    command = Command.DeviceAction(DeviceActionType.LOCK_SCREEN),
                    success = true,
                    message = "Screen locked"
                )
            } else {
                // Method 2: Fallback to accessibility service or settings intent
                openLockScreenSettings()
            }
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.LOCK_SCREEN),
                success = false,
                message = "Cannot lock screen. Device admin permission required or use accessibility service."
            )
        }
    }
    
    private fun openLockScreenSettings(): CommandResult {
        return try {
            val intent = Intent(Settings.ACTION_SECURITY_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.LOCK_SCREEN),
                success = true,
                message = "Opening security settings. Please set up screen lock."
            )
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.LOCK_SCREEN),
                success = false,
                message = "Failed to open security settings: ${e.message}"
            )
        }
    }
    
    private fun unlockScreen(): CommandResult {
        return CommandResult(
            command = Command.DeviceAction(DeviceActionType.UNLOCK_SCREEN),
            success = false,
            message = "Screen unlock requires biometric authentication or pin/pattern."
        )
    }
    
    private fun toggleWifi(enable: Boolean): CommandResult {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // For Android 10+, need to open WiFi settings
                val intent = Intent(Settings.ACTION_WIFI_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
                
                CommandResult(
                    command = Command.DeviceAction(if (enable) DeviceActionType.TURN_ON_WIFI else DeviceActionType.TURN_OFF_WIFI),
                    success = true,
                    message = "Opening WiFi settings. Please ${if (enable) "enable" else "disable"} WiFi manually."
                )
            } else {
                // For older Android versions (deprecated but keeping for reference)
                CommandResult(
                    command = Command.DeviceAction(if (enable) DeviceActionType.TURN_ON_WIFI else DeviceActionType.TURN_OFF_WIFI),
                    success = false,
                    message = "WiFi control requires manual action in settings."
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(if (enable) DeviceActionType.TURN_ON_WIFI else DeviceActionType.TURN_OFF_WIFI),
                success = false,
                message = "Failed to control WiFi: ${e.message}"
            )
        }
    }
    
    private fun toggleBluetooth(enable: Boolean): CommandResult {
        return try {
            val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            
            CommandResult(
                command = Command.DeviceAction(if (enable) DeviceActionType.TURN_ON_BLUETOOTH else DeviceActionType.TURN_OFF_BLUETOOTH),
                success = true,
                message = "Opening Bluetooth settings. Please ${if (enable) "enable" else "disable"} Bluetooth manually."
            )
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(if (enable) DeviceActionType.TURN_ON_BLUETOOTH else DeviceActionType.TURN_OFF_BLUETOOTH),
                success = false,
                message = "Failed to control Bluetooth: ${e.message}"
            )
        }
    }
    
    private fun adjustVolume(increase: Boolean): CommandResult {
        return try {
            val direction = if (increase) AudioManager.ADJUST_RAISE else AudioManager.ADJUST_LOWER
            audioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                direction,
                AudioManager.FLAG_SHOW_UI
            )
            
            CommandResult(
                command = Command.DeviceAction(if (increase) DeviceActionType.INCREASE_VOLUME else DeviceActionType.DECREASE_VOLUME),
                success = true,
                message = "Volume ${if (increase) "increased" else "decreased"}"
            )
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(if (increase) DeviceActionType.INCREASE_VOLUME else DeviceActionType.DECREASE_VOLUME),
                success = false,
                message = "Failed to adjust volume: ${e.message}"
            )
        }
    }
    
    private fun muteVolume(): CommandResult {
        return try {
            audioManager.adjustStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_MUTE,
                AudioManager.FLAG_SHOW_UI
            )
            
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.MUTE_VOLUME),
                success = true,
                message = "Volume muted"
            )
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.MUTE_VOLUME),
                success = false,
                message = "Failed to mute volume: ${e.message}"
            )
        }
    }
    
    private fun takeScreenshot(): CommandResult {
        return try {
            // On modern Android, taking screenshots programmatically requires 
            // MediaProjection API or accessibility service
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.TAKE_SCREENSHOT),
                success = false,
                message = "Taking screenshots requires accessibility service permission or manual action (Power + Volume Down)."
            )
        } catch (e: Exception) {
            CommandResult(
                command = Command.DeviceAction(DeviceActionType.TAKE_SCREENSHOT),
                success = false,
                message = "Failed to take screenshot: ${e.message}"
            )
        }
    }
}
