package com.jarvisai

import com.jarvisai.assistant.core.parser.IntentParser
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.DeviceActionType
import com.jarvisai.assistant.core.model.MediaType
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class IntentParserTest {
    
    private val intentParser = IntentParser()
    
    @Test
    fun parseCallCommand_withContact() {
        val command = intentParser.parseCommand("call John Doe")
        assertTrue(command is Command.Call)
        assertEquals("John Doe", (command as Command.Call).contact)
    }
    
    @Test
    fun parseCallCommand_withPhoneNumber() {
        val command = intentParser.parseCommand("call 1234567890")
        assertTrue(command is Command.Call)
        assertEquals("1234567890", (command as Command.Call).phoneNumber)
    }
    
    @Test
    fun parseMessageCommand() {
        val command = intentParser.parseCommand("send hello to Sarah on WhatsApp")
        assertTrue(command is Command.Message)
        val messageCommand = command as Command.Message
        assertEquals("hello", messageCommand.message)
        assertEquals("Sarah", messageCommand.contact)
        assertEquals("WhatsApp", messageCommand.platform)
    }
    
    @Test
    fun parsePlayMusicCommand() {
        val command = intentParser.parseCommand("play some music")
        assertTrue(command is Command.PlayMedia)
        val playCommand = command as Command.PlayMedia
        assertEquals(MediaType.MUSIC, playCommand.type)
    }
    
    @Test
    fun parseNavigationCommand() {
        val command = intentParser.parseCommand("navigate to Central Park")
        assertTrue(command is Command.Navigate)
        assertEquals("Central Park", (command as Command.Navigate).destination)
    }
    
    @Test
    fun parseDeviceActionCommand() {
        val command = intentParser.parseCommand("lock my screen")
        assertTrue(command is Command.DeviceAction)
        assertEquals(DeviceActionType.LOCK_SCREEN, (command as Command.DeviceAction).action)
    }
    
    @Test
    fun parseResearchCommand() {
        val command = intentParser.parseCommand("search for weather today")
        assertTrue(command is Command.Research)
        assertEquals("weather today", (command as Command.Research).query)
    }
    
    @Test
    fun parseUnknownCommand() {
        val command = intentParser.parseCommand("this is not a valid command")
        assertTrue(command is Command.Unknown)
    }
}
