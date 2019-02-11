package io.codelabs.todoapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*
import io.codelabs.todoapplication.data.TodoItem

/**
 * Data Access Object
 */
@Dao
interface TodoAppDao {

    /**
     * Create a new [TodoItem]
     */
    @Insert/*(onConflict = OnConflictStrategy.REPLACE)*/
    fun createTodoItem(todoItem: TodoItem)

    /**
     * Get a list of all [TodoItem]s
     */
    @Query("SELECT * FROM todos ORDER BY timestamp ASC")
    fun getAllItems(): LiveData<MutableList<TodoItem>>

    /**
     * Get a single [TodoItem] by [id]
     */
    @Query("SELECT * FROM todos WHERE id = :id")
    fun getTodoItem(id: Int): LiveData<TodoItem>

    /**
     * Delete a single [TodoItem]
     */
    @Delete
    fun deleteItem(todoItem: TodoItem)

    /**
     * Delete all [TodoItem]s
     */
    @Delete
    fun deleteAllItems(vararg items: TodoItem)

    /**
     * Update [todoItem]
     */
    @Update/*(onConflict = OnConflictStrategy.REPLACE)*/
    fun updateTodoItem(todoItem: TodoItem)

}