package com.jarvisai.assistant.core.actions

import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult

interface DeviceActionHandler {
    suspend fun executeCommand(command: Command): CommandResult
}
