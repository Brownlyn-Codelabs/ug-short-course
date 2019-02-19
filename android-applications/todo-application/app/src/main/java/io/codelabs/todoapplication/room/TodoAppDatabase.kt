package io.codelabs.todoapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.codelabs.todoapplication.data.TodoItem

/**
 * [RoomDatabase] implementation
 */
@Database(entities = [TodoItem::class], version = 1, exportSchema = false)
abstract class TodoAppDatabase : RoomDatabase() {

    companion object {
        private var instance: TodoAppDatabase? = null

        fun getInstance(context: Context): TodoAppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context,
                        TodoAppDatabase::class.java,
                        "todoapp.db"
                    )/*.allowMainThreadQueries()*/.fallbackToDestructiveMigration().build()
                }
            }
            return instance!!
        }
    }

    /**
     * Get an instance of the Data Access Object
     */
    abstract fun dao(): TodoAppDao

}