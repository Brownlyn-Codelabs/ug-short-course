package io.codelabs.todoapplication.room.repository

import io.codelabs.todoapplication.core.TodoApplication
import io.codelabs.todoapplication.data.TodoItem
import io.codelabs.todoapplication.room.TodoAppDao
import io.codelabs.todoapplication.room.TodoAppDatabase

class TodoTaskRepository constructor(application: TodoApplication) {
    private var dao: TodoAppDao = TodoAppDatabase.getInstance(application.applicationContext).dao()

    fun insert(todoItem: TodoItem) = /*ioScope.launch { dao.createTodoItem(todoItem) }*/ dao.createTodoItem(todoItem)

    fun delete(todoItem: TodoItem) = /*ioScope.launch { dao.deleteItem(todoItem) }*/ dao.deleteItem(todoItem)

    fun getSingleItem(id: Int) = /*ioScope.launch { dao.deleteItem(todoItem) }*/ dao.getTodoItem(id)

    fun update(todoItem: TodoItem) = /*ioScope.launch { dao.updateTodoItem(todoItem) }*/ dao.updateTodoItem(todoItem)

    fun getItems() =  /*ioScope.launch { dao.getAllItems() }*/ dao.getAllItems()

}