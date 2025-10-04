package com.jarvisai.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey
    val id: Long = 1, // Single row for user preferences
    val assistantName: String = "Jarvis",
    val userNickname: String? = null,
    val selectedVoice: String = "default",
    val isSerEnabled: Boolean = true,
    val isBatterySaverEnabled: Boolean = false,
    val wakeWordSensitivity: Float = 0.5f,
    val voiceCloneEnabled: Boolean = false,
    val voiceClonePath: String? = null,
    val isOnboardingComplete: Boolean = false
)
