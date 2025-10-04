package com.jarvisai.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jarvisai.ui.screens.history.HistoryScreen
import com.jarvisai.ui.screens.home.HomeScreen
import com.jarvisai.ui.screens.onboarding.OnboardingScreen
import com.jarvisai.ui.screens.settings.SettingsScreen
import com.jarvisai.ui.screens.voice.VoiceCloneScreen

@Composable
fun JarvisNavigation(
    navController: NavHostController,
    startDestination: String = JarvisScreen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(JarvisScreen.Onboarding.route) {
            Text("Hello Jarvis!")
        }
        
        composable(JarvisScreen.Home.route) {
            HomeScreen(
                onNavigateToSettings = {
                    navController.navigate(JarvisScreen.Settings.route)
                },
                onNavigateToHistory = {
                    navController.navigate(JarvisScreen.History.route)
                }
            )
        }
        
        composable(JarvisScreen.Settings.route) {
            SettingsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToVoiceClone = {
                    navController.navigate(JarvisScreen.VoiceClone.route)
                }
            )
        }
        
        composable(JarvisScreen.History.route) {
            HistoryScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(JarvisScreen.VoiceClone.route) {
            VoiceCloneScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class JarvisScreen(val route: String) {
    object Onboarding : JarvisScreen("onboarding")
    object Home : JarvisScreen("home")
    object Settings : JarvisScreen("settings")
    object History : JarvisScreen("history")
    object VoiceClone : JarvisScreen("voice_clone")
}
