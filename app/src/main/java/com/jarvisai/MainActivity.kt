package com.jarvisai

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
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
import com.jarvisai.utils.BatteryOptimizationHelper
import com.jarvisai.utils.PermissionManager
import com.jarvisai.utils.PermissionStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var userPreferencesRepository: UserPreferencesRepository
    
    private lateinit var batteryOptimizationLauncher: androidx.activity.result.ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: androidx.activity.result.ActivityResultLauncher<Array<String>>
    
    private var permissionStatus by mutableStateOf(PermissionManager.checkAllPermissions(this))
    private var isInitialized by mutableStateOf(false)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        Log.d("MainActivity", "Starting JarvisAI initialization")
        
        // Setup battery optimization launcher
        batteryOptimizationLauncher = BatteryOptimizationHelper.requestBatteryOptimizationExemption(this)
        
        // Setup permission launcher
        permissionLauncher = PermissionManager.createPermissionLauncher(this as FragmentActivity) { status ->
            permissionStatus = status
            Log.d("MainActivity", "Permission status updated: $status")
            
            if (status.hasMinimumPermissions && !isInitialized) {
                initializeApp()
            }
        }
        
        // Check permissions and initialize
        checkPermissionsAndInitialize()
        
        setContent {
            JarvisAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JarvisAIApp(
                        userPreferencesRepository = userPreferencesRepository,
                        permissionStatus = permissionStatus,
                        onRequestBatteryOptimization = {
                            batteryOptimizationLauncher.launch(
                                BatteryOptimizationHelper.createBatteryOptimizationIntent(this@MainActivity)
                            )
                        },
                        onRequestPermissions = {
                            PermissionManager.requestRequiredPermissions(this as FragmentActivity, permissionLauncher)
                        }
                    )
                }
            }
        }
    }
    
    private fun checkPermissionsAndInitialize() {
        permissionStatus = PermissionManager.checkAllPermissions(this)
        Log.d("MainActivity", "Current permission status: $permissionStatus")
        
        if (permissionStatus.hasMinimumPermissions) {
            initializeApp()
        } else {
            Log.w("MainActivity", "Missing required permissions, requesting...")
            PermissionManager.requestRequiredPermissions(this as FragmentActivity, permissionLauncher)
        }
    }
    
    private fun initializeApp() {
        if (isInitialized) return
        
        Log.d("MainActivity", "Initializing JarvisAI app")
        isInitialized = true
        
        // Initialize any required services here
        lifecycleScope.launch {
            try {
                // Initialize user preferences
                val preferences = userPreferencesRepository.getUserPreferences().first()
                Log.d("MainActivity", "User preferences loaded: $preferences")
                
                // Any other initialization can go here
                Log.d("MainActivity", "JarvisAI initialization complete")
            } catch (e: Exception) {
                Log.e("MainActivity", "Error during initialization", e)
            }
        }
    }
}

@Composable
fun JarvisAIApp(
    userPreferencesRepository: com.jarvisai.data.repository.UserPreferencesRepository,
    permissionStatus: PermissionStatus,
    onRequestBatteryOptimization: () -> Unit = {},
    onRequestPermissions: () -> Unit = {}
) {
    val navController = rememberNavController()
    var startDestination by remember { mutableStateOf(JarvisScreen.Onboarding.route) }
    
    // Check if onboarding is complete and permissions are granted
    LaunchedEffect(permissionStatus.hasMinimumPermissions) {
        if (permissionStatus.hasMinimumPermissions) {
            try {
                val preferences = userPreferencesRepository.getUserPreferences().first()
                if (preferences.isOnboardingComplete) {
                    startDestination = JarvisScreen.Home.route
                } else {
                    startDestination = JarvisScreen.Onboarding.route
                }
            } catch (e: Exception) {
                Log.e("JarvisAIApp", "Error checking onboarding status", e)
                startDestination = JarvisScreen.Onboarding.route
            }
        } else {
            // Show permission screen if permissions are missing
            startDestination = JarvisScreen.Onboarding.route
        }
    }
    
    JarvisNavigation(
        navController = navController,
        startDestination = startDestination,
        permissionStatus = permissionStatus,
        onRequestPermissions = onRequestPermissions,
        onRequestBatteryOptimization = onRequestBatteryOptimization
    )
}