package com.jarvisai.deviceactions.handler

import android.content.Context
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import javax.inject.Inject

interface DeviceActionHandler {
    suspend fun executeCommand(command: Command): CommandResult
}

class DeviceActionHandlerImpl @Inject constructor(
    private val context: Context,
    private val callHandler: CallHandler,
    private val messageHandler: MessageHandler,
    private val mediaHandler: MediaHandler,
    private val navigationHandler: NavigationHandler,
    private val systemActionHandler: SystemActionHandler
) : DeviceActionHandler {
    
    override suspend fun executeCommand(command: Command): CommandResult {
        return try {
            when (command) {
                is Command.Call -> callHandler.handleCall(command)
                is Command.Message -> messageHandler.handleMessage(command)
                is Command.PlayMedia -> mediaHandler.handlePlayMedia(command)
                is Command.Navigate -> navigationHandler.handleNavigation(command)
                is Command.DeviceAction -> systemActionHandler.handleDeviceAction(command)
                is Command.Research -> navigationHandler.handleResearch(command)
                is Command.Unknown -> CommandResult(
                    command = command,
                    success = false,
                    message = "I didn't understand that command. Please try again."
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "An error occurred while executing the command: ${e.message}"
            )
        }
    }
}
