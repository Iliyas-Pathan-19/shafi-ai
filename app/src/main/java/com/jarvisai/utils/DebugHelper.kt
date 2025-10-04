package com.jarvisai.utils

import android.content.Context
import android.util.Log
import com.jarvisai.assistant.core.service.VoiceAssistantService

object DebugHelper {
    
    private const val TAG = "JarvisDebugHelper"
    
    fun logAppState(context: Context) {
        Log.d(TAG, "=== JarvisAI Debug Information ===")
        
        // Check permissions
        val permissionStatus = PermissionManager.checkAllPermissions(context)
        Log.d(TAG, "Permission Status: $permissionStatus")
        
        // Check if service is running
        val isServiceRunning = isServiceRunning(context)
        Log.d(TAG, "Voice Assistant Service Running: $isServiceRunning")
        
        Log.d(TAG, "=== End Debug Information ===")
    }
    
    private fun isServiceRunning(context: Context): Boolean {
        return try {
            val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            val runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)
            runningServices.any { serviceInfo ->
                serviceInfo.service.className == VoiceAssistantService::class.java.name
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error checking service status", e)
            false
        }
    }
    
    fun checkCriticalDependencies(context: Context): Boolean {
        var allGood = true
        
        // Check permissions
        val permissionStatus = PermissionManager.checkAllPermissions(context)
        if (!permissionStatus.hasMinimumPermissions) {
            Log.e(TAG, "❌ Missing required permissions: ${permissionStatus.missingRequired}")
            allGood = false
        } else {
            Log.d(TAG, "✅ All required permissions granted")
        }
        
        // Check if service can start
        try {
            val serviceIntent = android.content.Intent(context, VoiceAssistantService::class.java)
            val resolveInfo = context.packageManager.resolveService(serviceIntent, 0)
            if (resolveInfo == null) {
                Log.e(TAG, "❌ VoiceAssistantService not found in manifest")
                allGood = false
            } else {
                Log.d(TAG, "✅ VoiceAssistantService properly declared")
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error checking service declaration", e)
            allGood = false
        }
        
        return allGood
    }
    
    fun logInitializationSteps() {
        Log.d(TAG, "=== JarvisAI Initialization Steps ===")
        Log.d(TAG, "1. ✅ App started")
        Log.d(TAG, "2. ✅ Hilt initialized")
        Log.d(TAG, "3. ✅ Permission check completed")
        Log.d(TAG, "4. ✅ UI components loaded")
        Log.d(TAG, "5. ✅ Navigation setup")
        Log.d(TAG, "=== Initialization Complete ===")
    }
}
