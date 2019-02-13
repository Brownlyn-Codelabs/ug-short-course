package io.codelabs.chatapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.codelabs.chatapplication.data.User

/**
 * [RoomDatabase] implementation
 */
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class ChatAppDatabase : RoomDatabase() {

    companion object {
        private val lock = Any()
        private var instance: ChatAppDatabase? = null

        fun getInstance(context: Context): ChatAppDatabase {
            if (instance == null) {
                synchronized(lock) {
                    instance = Room.databaseBuilder(
                        context,
                        ChatAppDatabase::class.java,
                        "chatapp.db"
                    )/*.allowMainThreadQueries()*/.fallbackToDestructiveMigration().build()
                }
            }
            return instance!!
        }
    }

    /**
     * Get an instance of the Data Access Object
     */
    abstract fun dao(): ChatAppDao

}