package com.jarvisai.deviceactions.handler

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.ContactsContract
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.jarvisai.assistant.core.model.Command
import com.jarvisai.assistant.core.model.CommandResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CallHandler @Inject constructor(
    private val context: Context
) {
    
    fun handleCall(command: Command.Call): CommandResult {
        if (!hasCallPermission()) {
            return CommandResult(
                command = command,
                success = false,
                message = "Call permission is required to make phone calls"
            )
        }
        
        val phoneNumber = when {
            command.phoneNumber != null -> command.phoneNumber
            command.contact != null -> getContactPhoneNumber(command.contact!!)
            else -> null
        }
        
        return if (phoneNumber != null) {
            makeCall(phoneNumber, command)
        } else {
            CommandResult(
                command = command,
                success = false,
                message = "Could not find phone number for ${command.contact ?: "unknown contact"}"
            )
        }
    }
    
    private fun hasCallPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context, 
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    private fun getContactPhoneNumber(contactName: String): String? {
        if (!hasContactsPermission()) return null
        
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
                    it.getString(phoneNumberIndex)
                } else null
            } else null
        }
    }
    
    private fun hasContactsPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_CONTACTS
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    private fun makeCall(phoneNumber: String, command: Command.Call): CommandResult {
        return try {
            val callIntent = Intent(Intent.ACTION_CALL).apply {
                data = "tel:$phoneNumber".toUri()
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            context.startActivity(callIntent)
            
            CommandResult(
                command = command,
                success = true,
                message = "Calling $phoneNumber"
            )
        } catch (e: Exception) {
            CommandResult(
                command = command,
                success = false,
                message = "Failed to make call: ${e.message}"
            )
        }
    }
}
