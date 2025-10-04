package com.jarvisai.deviceactions.handler

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import com.jarvisai.assistant.core.model.MediaType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaHandler @Inject constructor(
    private val context: Context
) {
    
    fun handlePlayMedia(command: Command.PlayMedia): CommandResult {
        return when (command.type) {
            MediaType.MUSIC -> playMusic(command)
            MediaType.VIDEO -> playVideo(command)
            MediaType.PODCAST -> playPodcast(command)
            MediaType.ANY -> playAnyMedia(command)
        }
    }
    
    private fun playMusic(command: Command.PlayMedia): CommandResult {
        return try {
            // First try to play from local music apps
            val musicIntent = if (command.query.isNullOrEmpty()) {
                // Play any music
                Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            } else {
                // Search for specific music
                Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH).apply {
                    putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Media.ENTRY_CONTENT_TYPE)
                    putExtra(MediaStore.EXTRA_MEDIA_TITLE, command.query)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            }
            
            // Try local music first
            if (context.packageManager.queryIntentActivities(musicIntent, PackageManager.MATCH_DEFAULT_ONLY).isNotEmpty()) {
                context.startActivity(musicIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Playing music: ${command.query ?: "random music"}"
                )
            } else {
                // Fallback to YouTube
                val query = (command.query ?: "").let { if (it.isBlank()) "music" else "$it music" }
                playOnYouTube(query)
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to play music: ${e.message}"
            )
        }
    }
    
    private fun playVideo(command: Command.PlayMedia): CommandResult {
        return try {
            if (command.query.isNullOrEmpty()) {
                // Open video player
                val videoIntent = Intent(Intent.ACTION_VIEW).apply {
                    type = "video/*"
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(videoIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening video player"
                )
            } else {
                // Search for video on YouTube
                playOnYouTube(command.query ?: "video")
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to play video: ${e.message}"
            )
        }
    }
    
    private fun playPodcast(command: Command.PlayMedia): CommandResult {
        return try {
            val query = command.query ?: "podcast"
            
            // Try to open podcast apps
            val podcastApps = listOf(
                "com.spotify.music",
                "com.google.android.apps.podcasts",
                "fm.castbox.audiobook.radio.podcast",
                "com.bambuna.podcastaddict"
            )
            
            var appOpened = false
            for (packageName in podcastApps) {
                if (isAppInstalled(packageName)) {
                    val intent = Intent(Intent.ACTION_SEARCH).apply {
                        setPackage(packageName)
                        putExtra("query", query)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    
                    try {
                        context.startActivity(intent)
                        appOpened = true
                        break
                    } catch (e: Exception) {
                        // Continue to next app
                    }
                }
            }
            
            if (appOpened) {
                CommandResult(
                    command = command,
                    success = true,
                    message = "Searching for podcast: $query"
                )
            } else {
                // Fallback to YouTube
                playOnYouTube("$query podcast")
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to play podcast: ${e.message}"
            )
        }
    }
    
    private fun playAnyMedia(command: Command.PlayMedia): CommandResult {
        return try {
            val query = command.query
            
            if (query.isNullOrEmpty()) {
                // Open default media player
                val mediaIntent = Intent(Intent.ACTION_VIEW).apply {
                    type = "audio/*"
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(mediaIntent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening media player"
                )
            } else {
                // Search on YouTube
                playOnYouTube(query)
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to play media: ${e.message}"
            )
        }
    }
    
    private fun playOnYouTube(query: String): CommandResult {
        return try {
            val youtubeIntent = Intent(Intent.ACTION_SEARCH).apply {
                setPackage("com.google.android.youtube")
                putExtra("query", query)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            if (isAppInstalled("com.google.android.youtube")) {
                context.startActivity(youtubeIntent)
                CommandResult(
                    command = Command.PlayMedia(query, MediaType.ANY),
                    success = true,
                    message = "Searching YouTube for: $query"
                )
            } else {
                // Fallback to browser YouTube search
                val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.youtube.com/results?search_query=${Uri.encode(query)}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(browserIntent)
                CommandResult(
                    command = Command.PlayMedia(query, MediaType.ANY),
                    success = true,
                    message = "Opening YouTube in browser for: $query"
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = Command.PlayMedia(query, MediaType.ANY),
                success = false,
                message = "Failed to search YouTube: ${e.message}"
            )
        }
    }
    
    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            context.packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}
