package com.jarvisai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.jarvisai.data.repository.UserPreferencesRepository
import com.jarvisai.ui.navigation.JarvisNavigation
import com.jarvisai.ui.navigation.JarvisScreen
import com.jarvisai.ui.theme.JarvisAITheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var userPreferencesRepository: UserPreferencesRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            JarvisAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JarvisAIApp(userPreferencesRepository)
                }
            }
        }
    }
}

@Composable
fun JarvisAIApp(
    repo: com.jarvisai.data.repository.UserPreferencesRepository
) {
    val navController = rememberNavController()
    var startDestination by remember { mutableStateOf(JarvisScreen.Onboarding.route) }
    
    // Check if onboarding is complete
    LaunchedEffect(Unit) {
        try {
            val preferences = repo.getUserPreferences().first()
            if (preferences.isOnboardingComplete) {
                startDestination = JarvisScreen.Home.route
            }
        } catch (e: Exception) {
            // If there's an error, default to onboarding
            startDestination = JarvisScreen.Onboarding.route
        }
    }
    
    JarvisNavigation(
        navController = navController,
        startDestination = startDestination
    )
}