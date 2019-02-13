package io.codelabs.todoapplication.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.codelabs.todoapplication.R
import io.codelabs.todoapplication.core.TodoApplication
import io.codelabs.todoapplication.data.TodoItem
import io.codelabs.todoapplication.room.viewmodel.TodoTaskViewModel
import io.codelabs.todoapplication.room.viewmodel.factory.TodoTaskFactory
import io.codelabs.todoapplication.ui.adapter.TodoTaskAdapter
import io.codelabs.todoapplication.util.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.empty_text)

        val layoutManager = LinearLayoutManager(this)
        grid_todos.layoutManager = layoutManager
        grid_todos.setHasFixedSize(true)
        grid_todos.itemAnimator = DefaultItemAnimator()
        val adapter = TodoTaskAdapter(this)
        grid_todos.adapter = adapter

        // Create view model instance
        val viewModel: TodoTaskViewModel = ViewModelProviders.of(this, TodoTaskFactory(application as TodoApplication))
            .get(TodoTaskViewModel::class.java)

        uiScope.launch {
            viewModel.getTodoItems().observe(this@MainActivity,
                Observer<MutableList<TodoItem>?> { items ->
                    if (items != null) {
                        adapter.addItems(items)
                    }
                })
        }
    }

    fun addNewTodo(v: View?) = startActivity(Intent(this@MainActivity, CreateTodoActivity::class.java))

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_search -> {
                //todo: search implementation
                toast(message = "Not available")
            }

            R.id.menu_filter -> {
                //todo: search implementation
                toast(message = "Not available")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
