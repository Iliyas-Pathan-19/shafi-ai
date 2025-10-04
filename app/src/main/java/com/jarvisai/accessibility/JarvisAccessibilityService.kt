package com.jarvisai.accessibility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import androidx.lifecycle.LifecycleService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class JarvisAccessibilityService : AccessibilityService() {
    
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                "com.jarvisai.ACTION_LOCK_SCREEN" -> {
                    Log.d(TAG, "Received lock screen command")
                    lockScreen()
                }
                "com.jarvisai.ACTION_TAKE_SCREENSHOT" -> {
                    Log.d(TAG, "Received screenshot command")
                    takeScreenshot()
                }
                "com.jarvisai.ACTION_GO_HOME" -> {
                    Log.d(TAG, "Received go home command")
                    goHome()
                }
                "com.jarvisai.ACTION_GO_BACK" -> {
                    Log.d(TAG, "Received go back command")
                    goBack()
                }
                "com.jarvisai.ACTION_OPEN_RECENTS" -> {
                    Log.d(TAG, "Received open recents command")
                    openRecentApps()
                }
            }
        }
    }
    
    companion object {
        private const val TAG = "JarvisAccessibility"
        
        fun isAccessibilityServiceEnabled(context: Context): Boolean {
            val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager
            val enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
            
            return enabledServices.any { serviceInfo ->
                serviceInfo.resolveInfo.serviceInfo.packageName == context.packageName &&
                serviceInfo.resolveInfo.serviceInfo.name == JarvisAccessibilityService::class.java.name
            }
        }
        
        fun openAccessibilitySettings(context: Context) {
            val intent = Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
    
    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d(TAG, "Jarvis Accessibility Service Connected")
        
        // Register broadcast receiver for commands
        val filter = IntentFilter().apply {
            addAction("com.jarvisai.ACTION_LOCK_SCREEN")
            addAction("com.jarvisai.ACTION_TAKE_SCREENSHOT")
            addAction("com.jarvisai.ACTION_GO_HOME")
            addAction("com.jarvisai.ACTION_GO_BACK")
            addAction("com.jarvisai.ACTION_OPEN_RECENTS")
        }
        registerReceiver(broadcastReceiver, filter)
        
        val info = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or
                        AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED or
                        AccessibilityEvent.TYPE_VIEW_CLICKED
            
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            
            flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS or
                   AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                flags = flags or AccessibilityServiceInfo.FLAG_REQUEST_FILTER_KEY_EVENTS
            }
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                flags = flags or AccessibilityServiceInfo.FLAG_REQUEST_ACCESSIBILITY_BUTTON
            }
            
            notificationTimeout = 100
        }
        
        serviceInfo = info
    }
    
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            Log.d(TAG, "Accessibility event: ${it.eventType}")
            
            when (it.eventType) {
                AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                    handleWindowStateChanged(it)
                }
                AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                    handleViewClicked(it)
                }
            }
        }
    }
    
    private fun handleWindowStateChanged(event: AccessibilityEvent) {
        val packageName = event.packageName?.toString()
        val className = event.className?.toString()
        
        Log.d(TAG, "Window changed: $packageName/$className")
        
        // Handle lock screen detection
        if (isLockScreen(packageName, className)) {
            Log.d(TAG, "Lock screen detected")
            // You can add custom logic here for lock screen interactions
        }
    }
    
    private fun handleViewClicked(event: AccessibilityEvent) {
        val packageName = event.packageName?.toString()
        val className = event.className?.toString()
        
        Log.d(TAG, "View clicked: $packageName/$className")
    }
    
    private fun isLockScreen(packageName: String?, className: String?): Boolean {
        return when {
            packageName == "com.android.systemui" && 
            (className?.contains("Keyguard") == true || className?.contains("Lock") == true) -> true
            
            packageName == "com.android.keyguard" -> true
            
            packageName == "com.samsung.android.knox.lockscreen" -> true
            
            packageName == "com.oneplus.launcher" && className?.contains("Lock") == true -> true
            
            else -> false
        }
    }
    
    fun lockScreen() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                // Use DevicePolicyManager for Android 9+
                performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)
            } else {
                // For older versions, try to simulate power button press
                performGlobalAction(GLOBAL_ACTION_POWER_DIALOG)
            }
            Log.d(TAG, "Lock screen command executed")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to lock screen", e)
        }
    }
    
    fun unlockScreen() {
        try {
            // This is more complex and may require additional permissions
            // For now, we'll just log the attempt
            Log.d(TAG, "Unlock screen requested (requires additional implementation)")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to unlock screen", e)
        }
    }
    
    fun takeScreenshot() {
        try {
            performGlobalAction(GLOBAL_ACTION_TAKE_SCREENSHOT)
            Log.d(TAG, "Screenshot taken")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to take screenshot", e)
        }
    }
    
    fun goHome() {
        try {
            performGlobalAction(GLOBAL_ACTION_HOME)
            Log.d(TAG, "Home action performed")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to go home", e)
        }
    }
    
    fun goBack() {
        try {
            performGlobalAction(GLOBAL_ACTION_BACK)
            Log.d(TAG, "Back action performed")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to go back", e)
        }
    }
    
    fun openRecentApps() {
        try {
            performGlobalAction(GLOBAL_ACTION_RECENTS)
            Log.d(TAG, "Recent apps opened")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to open recent apps", e)
        }
    }
    
    override fun onInterrupt() {
        Log.d(TAG, "Jarvis Accessibility Service Interrupted")
    }
    
    override fun onDestroy() {
        try {
            unregisterReceiver(broadcastReceiver)
        } catch (e: Exception) {
            Log.e(TAG, "Error unregistering broadcast receiver", e)
        }
        super.onDestroy()
        Log.d(TAG, "Jarvis Accessibility Service Destroyed")
    }
}
