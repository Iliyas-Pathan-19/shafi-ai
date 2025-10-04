package com.jarvisai.data.entity

// Temporarily disabled due to Room being disabled
// import androidx.room.Entity
// import androidx.room.PrimaryKey

// @Entity(tableName = "command_history")
data class CommandHistory(
    // @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val command: String,
    val transcript: String,
    val response: String?,
    val executedAt: Long,
    val successful: Boolean,
    val detectedEmotion: String? = null,
    val confidence: Float? = null
)
