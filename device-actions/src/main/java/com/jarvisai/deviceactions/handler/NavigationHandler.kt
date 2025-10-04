package com.jarvisai.deviceactions.handler

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationHandler @Inject constructor(
    private val context: Context
) {
    
    fun handleNavigation(command: Command.Navigate): CommandResult {
        return try {
            val destination = command.destination
            
            // Create Google Maps intent
            val mapsIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=${Uri.encode(destination)}")
                setPackage("com.google.android.apps.maps")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            // Check if Google Maps is installed
            val packageManager = context.packageManager
            if (mapsIntent.resolveActivity(packageManager) != null) {
                context.startActivity(mapsIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening Google Maps for directions to $destination"
                )
            } else {
                // Fallback to generic geo intent
                val genericMapsIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("geo:0,0?q=${Uri.encode(destination)}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(genericMapsIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening maps for directions to $destination"
                )
            }
        } catch (e: Exception) {
            // Final fallback to browser
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.google.com/maps/search/${Uri.encode(command.destination)}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(browserIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening Google Maps in browser for ${command.destination}"
                )
            } catch (ex: Exception) {
                CommandResult(
                    command = command,
                    success = false,
                    message = "Failed to open navigation: ${ex.message}"
                )
            }
        }
    }
    
    fun handleResearch(command: Command.Research): CommandResult {
        return try {
            val query = command.query
            val platform = command.platform?.lowercase()
            
            val searchUrl = when (platform) {
                "google" -> "https://www.google.com/search?q=${Uri.encode(query)}"
                "bing" -> "https://www.bing.com/search?q=${Uri.encode(query)}"
                "perplexity" -> "https://www.perplexity.ai/?q=${Uri.encode(query)}"
                else -> "https://www.google.com/search?q=${Uri.encode(query)}"
            }
            
            val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(searchUrl)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            context.startActivity(browserIntent)
            
            val platformName = platform?.replaceFirstChar { it.uppercase() } ?: "Google"
            CommandResult(
                command = command,
                success = true,
                message = "Searching $platformName for: $query"
            )
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to perform research: ${e.message}"
            )
        }
    }
}
