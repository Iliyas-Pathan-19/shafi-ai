package com.jarvisai.assistant.core.parser

import com.jarvisai.assistant.core.model.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentParser @Inject constructor() {
    
    private val callPatterns = listOf(
        Regex("""(?:call|phone|dial)\s+(.+)""", RegexOption.IGNORE_CASE),
        Regex("""(?:call|phone)\s+(\d+)""", RegexOption.IGNORE_CASE)
    )
    
    private val messagePatterns = listOf(
        Regex("""(?:send|text|message)\s+(.+?)\s+to\s+(.+?)(?:\s+on\s+(whatsapp|telegram|sms|instagram|twitter))?""", RegexOption.IGNORE_CASE),
        Regex("""(?:text|message)\s+(.+?)\s+saying\s+(.+)""", RegexOption.IGNORE_CASE)
    )
    
    private val mediaPatterns = listOf(
        Regex("""(?:play|listen to|start)\s+(?:songs?|music)\s*(.*)""", RegexOption.IGNORE_CASE),
        Regex("""(?:play|watch)\s+(.+?)\s+(?:video|movie)""", RegexOption.IGNORE_CASE),
        Regex("""(?:play)\s+(.+)""", RegexOption.IGNORE_CASE)
    )
    
    private val navigationPatterns = listOf(
        Regex("""(?:navigate to|go to|directions to|where is)\s+(.+)""", RegexOption.IGNORE_CASE),
        Regex("""(?:map|maps)\s+(.+)""", RegexOption.IGNORE_CASE)
    )
    
    private val deviceActionPatterns = mapOf(
        DeviceActionType.LOCK_SCREEN to listOf(
            Regex("""lock\s+(?:the\s+)?screen""", RegexOption.IGNORE_CASE),
            Regex("""lock\s+(?:my\s+)?phone""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.TURN_ON_WIFI to listOf(
            Regex("""turn\s+on\s+wifi""", RegexOption.IGNORE_CASE),
            Regex("""enable\s+wifi""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.TURN_OFF_WIFI to listOf(
            Regex("""turn\s+off\s+wifi""", RegexOption.IGNORE_CASE),
            Regex("""disable\s+wifi""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.TURN_ON_BLUETOOTH to listOf(
            Regex("""turn\s+on\s+bluetooth""", RegexOption.IGNORE_CASE),
            Regex("""enable\s+bluetooth""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.TURN_OFF_BLUETOOTH to listOf(
            Regex("""turn\s+off\s+bluetooth""", RegexOption.IGNORE_CASE),
            Regex("""disable\s+bluetooth""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.INCREASE_VOLUME to listOf(
            Regex("""(?:increase|raise|turn up)\s+(?:the\s+)?volume""", RegexOption.IGNORE_CASE),
            Regex("""volume\s+up""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.DECREASE_VOLUME to listOf(
            Regex("""(?:decrease|lower|turn down)\s+(?:the\s+)?volume""", RegexOption.IGNORE_CASE),
            Regex("""volume\s+down""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.MUTE_VOLUME to listOf(
            Regex("""mute""", RegexOption.IGNORE_CASE),
            Regex("""silence""", RegexOption.IGNORE_CASE)
        ),
        DeviceActionType.TAKE_SCREENSHOT to listOf(
            Regex("""take\s+(?:a\s+)?screenshot""", RegexOption.IGNORE_CASE),
            Regex("""capture\s+screen""", RegexOption.IGNORE_CASE)
        )
    )
    
    private val researchPatterns = listOf(
        Regex("""(?:search|research|look up|find)\s+(.+?)(?:\s+on\s+(google|bing|perplexity))?""", RegexOption.IGNORE_CASE),
        Regex("""(?:what is|tell me about)\s+(.+)""", RegexOption.IGNORE_CASE)
    )
    
    fun parseCommand(transcript: String): Command {
        val cleanTranscript = transcript.trim()
        
        // Try to match call patterns
        callPatterns.forEach { pattern ->
            pattern.find(cleanTranscript)?.let { match ->
                val contactOrNumber = match.groupValues[1]
                return if (contactOrNumber.matches(Regex("""\d+"""))) {
                    Command.Call(null, contactOrNumber)
                } else {
                    Command.Call(contactOrNumber, null)
                }
            }
        }
        
        // Try to match message patterns
        messagePatterns.forEach { pattern ->
            pattern.find(cleanTranscript)?.let { match ->
                return when (match.groupValues.size) {
                    4 -> Command.Message(
                        contact = match.groupValues[2],
                        message = match.groupValues[1],
                        platform = match.groupValues[3].takeIf { it.isNotEmpty() }
                    )
                    3 -> Command.Message(
                        contact = match.groupValues[1],
                        message = match.groupValues[2],
                        platform = null
                    )
                    else -> Command.Unknown
                }
            }
        }
        
        // Try to match navigation patterns
        navigationPatterns.forEach { pattern ->
            pattern.find(cleanTranscript)?.let { match ->
                return Command.Navigate(match.groupValues[1])
            }
        }
        
        // Try to match device actions
        deviceActionPatterns.forEach { (action, patterns) ->
            patterns.forEach { pattern ->
                if (pattern.matches(cleanTranscript)) {
                    return Command.DeviceAction(action)
                }
            }
        }
        
        // Try to match media patterns
        mediaPatterns.forEach { pattern ->
            pattern.find(cleanTranscript)?.let { match ->
                val query = match.groupValues[1].takeIf { it.isNotEmpty() }
                val type = when {
                    cleanTranscript.contains("video", ignoreCase = true) || 
                    cleanTranscript.contains("movie", ignoreCase = true) -> MediaType.VIDEO
                    cleanTranscript.contains("music", ignoreCase = true) || 
                    cleanTranscript.contains("song", ignoreCase = true) -> MediaType.MUSIC
                    cleanTranscript.contains("podcast", ignoreCase = true) -> MediaType.PODCAST
                    else -> MediaType.ANY
                }
                return Command.PlayMedia(query, type)
            }
        }
        
        // Try to match research patterns
        researchPatterns.forEach { pattern ->
            pattern.find(cleanTranscript)?.let { match ->
                return Command.Research(
                    query = match.groupValues[1],
                    platform = match.groupValues.getOrNull(2)?.takeIf { it.isNotEmpty() }
                )
            }
        }
        
        return Command.Unknown
    }
    
    fun extractContactName(input: String): String? {
        // Simple contact name extraction - can be enhanced with ML
        val words = input.split(" ")
        return words.find { word -> 
            word.length > 2 && 
            word.first().isUpperCase() && 
            !word.contains(Regex("""\d"""))
        }
    }
    
    fun extractPhoneNumber(input: String): String? {
        val phonePattern = Regex("""(\+?\d{1,4}[\s.-]?)?\(?\d{3,4}\)?[\s.-]?\d{3,4}[\s.-]?\d{4,6}""")
        return phonePattern.find(input)?.value
    }
}
