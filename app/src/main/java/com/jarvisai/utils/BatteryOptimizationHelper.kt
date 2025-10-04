package com.jarvisai.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class BatteryOptimizationHelper {
    
    companion object {
        fun isBatteryOptimizationIgnored(context: Context): Boolean {
            val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                powerManager.isIgnoringBatteryOptimizations(context.packageName)
            } else {
                true // For older versions, assume optimization is not a concern
            }
        }
        
        fun requestBatteryOptimizationExemption(activity: ComponentActivity): ActivityResultLauncher<Intent> {
            return activity.registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                // Handle the result if needed
                // The system will show the battery optimization settings
            }
        }
        
        fun createBatteryOptimizationIntent(context: Context): Intent {
            return Intent().apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                    data = Uri.parse("package:${context.packageName}")
                } else {
                    action = Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS
                }
            }
        }
        
        fun openBatteryOptimizationSettings(context: Context) {
            val intent = Intent().apply {
                action = Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS
            }
            context.startActivity(intent)
        }
    }
}
