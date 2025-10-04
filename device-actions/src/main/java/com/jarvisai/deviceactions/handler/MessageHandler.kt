package com.jarvisai.deviceactions.handler

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.ContactsContract
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageHandler @Inject constructor(
    private val context: Context
) {
    
    fun handleMessage(command: Command.Message): CommandResult {
        val platform = command.platform?.lowercase() ?: "sms"
        
        return when (platform) {
            "sms", "text" -> sendSms(command)
            "whatsapp" -> sendWhatsAppMessage(command)
            "telegram" -> sendTelegramMessage(command)
            "instagram" -> sendInstagramMessage(command)
            "twitter" -> sendTwitterMessage(command)
            else -> sendGenericMessage(command)
        }
    }
    
    private fun sendSms(command: Command.Message): CommandResult {
        val phoneNumber = command.contact?.let { getContactPhoneNumber(it) }
        
        return if (phoneNumber != null) {
            try {
                val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("sms:$phoneNumber")
                    putExtra("sms_body", command.message)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                
                context.startActivity(smsIntent)
                
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening SMS to ${command.contact} with message: ${command.message}"
                )
            } catch (e: Exception) {
                CommandResult(
                    command = command,
                    success = false,
                    message = "Failed to send SMS: ${e.message}"
                )
            }
        } else {
            CommandResult(
                command = command,
                success = false,
                message = "Could not find phone number for ${command.contact}"
            )
        }
    }
    
    private fun sendWhatsAppMessage(command: Command.Message): CommandResult {
        return try {
            val phoneNumber = command.contact?.let { getContactPhoneNumber(it) }
            
            val intent = if (phoneNumber != null) {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://wa.me/$phoneNumber?text=${Uri.encode(command.message)}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            } else {
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, command.message)
                    setPackage("com.whatsapp")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            }
            
            if (isAppInstalled("com.whatsapp")) {
                context.startActivity(intent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening WhatsApp with message: ${command.message}"
                )
            } else {
                CommandResult(
                    command = command,
                    success = false,
                    message = "WhatsApp is not installed"
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to send WhatsApp message: ${e.message}"
            )
        }
    }
    
    private fun sendTelegramMessage(command: Command.Message): CommandResult {
        return try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, command.message)
                setPackage("org.telegram.messenger")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            if (isAppInstalled("org.telegram.messenger")) {
                context.startActivity(intent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening Telegram with message: ${command.message}"
                )
            } else {
                CommandResult(
                    command = command,
                    success = false,
                    message = "Telegram is not installed"
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to send Telegram message: ${e.message}"
            )
        }
    }
    
    private fun sendInstagramMessage(command: Command.Message): CommandResult {
        return try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, command.message)
                setPackage("com.instagram.android")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            if (isAppInstalled("com.instagram.android")) {
                context.startActivity(intent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening Instagram with message: ${command.message}"
                )
            } else {
                CommandResult(
                    command = command,
                    success = false,
                    message = "Instagram is not installed"
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to send Instagram message: ${e.message}"
            )
        }
    }
    
    private fun sendTwitterMessage(command: Command.Message): CommandResult {
        return try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, command.message)
                setPackage("com.twitter.android")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            if (isAppInstalled("com.twitter.android")) {
                context.startActivity(intent)
                CommandResult(
                    command = command,
                    success = true,
                    message = "Opening Twitter with message: ${command.message}"
                )
            } else {
                CommandResult(
                    command = command,
                    success = false,
                    message = "Twitter is not installed"
                )
            }
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to send Twitter message: ${e.message}"
            )
        }
    }
    
    private fun sendGenericMessage(command: Command.Message): CommandResult {
        return try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, command.message)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            val chooser = Intent.createChooser(intent, "Send message via...")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            
            context.startActivity(chooser)
            
            CommandResult(
                command = command,
                success = true,
                message = "Opening messaging apps with message: ${command.message}"
            )
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to send message: ${e.message}"
            )
        }
    }
    
    private fun getContactPhoneNumber(contactName: String): String? {
        try {
            val cursor = context.contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
                "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                arrayOf("%$contactName%"),
                null
            )
            
            return cursor?.use {
                if (it.moveToFirst()) {
                    val phoneNumberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    if (phoneNumberIndex >= 0) {
                        it.getString(phoneNumberIndex)?.replace(Regex("[^\\d+]"), "")
                    } else null
                } else null
            }
        } catch (e: Exception) {
            return null
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
