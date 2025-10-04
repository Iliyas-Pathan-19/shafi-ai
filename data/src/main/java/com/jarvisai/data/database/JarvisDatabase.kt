package com.jarvisai.data.database

// Temporarily disabled due to Windows SQLite native library issues
// import androidx.room.Database
// import androidx.room.Room
// import androidx.room.RoomDatabase
import android.content.Context
// import com.jarvisai.data.dao.CommandHistoryDao
// import com.jarvisai.data.dao.UserPreferencesDao
// import com.jarvisai.data.entity.CommandHistory
// import com.jarvisai.data.entity.UserPreferences

// @Database(
//     entities = [CommandHistory::class, UserPreferences::class],
//     version = 1,
//     exportSchema = false
// )
// abstract class JarvisDatabase : RoomDatabase() {
//     
//     abstract fun commandHistoryDao(): CommandHistoryDao
//     abstract fun userPreferencesDao(): UserPreferencesDao
//     
//     companion object {
//         @Volatile
//         private var INSTANCE: JarvisDatabase? = null
//         
//         fun getDatabase(context: Context): JarvisDatabase {
//             return INSTANCE ?: synchronized(this) {
//                 val instance = Room.databaseBuilder(
//                     context.applicationContext,
//                     JarvisDatabase::class.java,
//                     "jarvis_database"
//                 )
//                 .fallbackToDestructiveMigration(true)
//                 // Disable database verification to avoid SQLite native library issues
//                 .enableMultiInstanceInvalidation()
//                 .build()
//                 INSTANCE = instance
//                 instance
//             }
//         }
//     }
// }

// Temporary placeholder class
class JarvisDatabase {
    companion object {
        fun getDatabase(context: Context): JarvisDatabase {
            return JarvisDatabase()
        }
    }
}
