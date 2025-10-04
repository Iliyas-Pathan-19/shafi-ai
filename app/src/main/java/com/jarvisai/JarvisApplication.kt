package com.jarvisai

import android.app.Application
import androidx.lifecycle.lifecycleScope
import com.jarvisai.data.repository.UserPreferencesRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class JarvisApplication : Application() {
    
    @Inject
    lateinit var userPreferencesRepository: UserPreferencesRepository
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize user preferences on app start
        initializeDefaultPreferences()
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
