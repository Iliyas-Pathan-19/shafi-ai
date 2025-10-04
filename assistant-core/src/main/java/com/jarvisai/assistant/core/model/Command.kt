package com.jarvisai.assistant.core.model

sealed class Command {
    data class Call(val contact: String?, val phoneNumber: String?) : Command()
    data class Message(val contact: String?, val message: String, val platform: String?) : Command()
    data class PlayMedia(val query: String?, val type: MediaType) : Command()
    data class Navigate(val destination: String) : Command()
    data class DeviceAction(val action: DeviceActionType) : Command()
    data class Research(val query: String, val platform: String?) : Command()
    object Unknown : Command()
}

enum class MediaType {
    MUSIC, VIDEO, PODCAST, ANY
}

enum class DeviceActionType {
    LOCK_SCREEN, UNLOCK_SCREEN, TURN_ON_WIFI, TURN_OFF_WIFI,
    TURN_ON_BLUETOOTH, TURN_OFF_BLUETOOTH, INCREASE_VOLUME,
    DECREASE_VOLUME, MUTE_VOLUME, TAKE_SCREENSHOT
}

data class CommandResult(
    val command: Command,
    val success: Boolean,
    val message: String,
    val executionTime: Long = System.currentTimeMillis()
)
