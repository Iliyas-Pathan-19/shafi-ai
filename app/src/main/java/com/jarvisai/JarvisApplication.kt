package com.jarvisai

import android.app.Application
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.jarvisai.data.repository.UserPreferencesRepository
import com.jarvisai.utils.DebugHelper
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class JarvisApplication : Application() {
    
    @Inject
    lateinit var userPreferencesRepository: UserPreferencesRepository
    
    override fun onCreate() {
        super.onCreate()
        
        Log.d("JarvisApplication", "🚀 JarvisAI Application starting...")
        
        // Initialize user preferences on app start
        initializeDefaultPreferences()
        
        // Run debug checks
        DebugHelper.logInitializationSteps()
        DebugHelper.logAppState(this)
        
        Log.d("JarvisApplication", "✅ JarvisAI Application initialized successfully")
    }
    
    private fun initializeDefaultPreferences() {
        // Use a simple coroutine scope for initialization
        // In a real app, you might want to use a more sophisticated approach
        kotlinx.coroutines.GlobalScope.launch {
            try {
                userPreferencesRepository.initializePreferences()
            } catch (e: Exception) {
                // Log error but don't crash the app
                e.printStackTrace()
            }
        }
    }
}
