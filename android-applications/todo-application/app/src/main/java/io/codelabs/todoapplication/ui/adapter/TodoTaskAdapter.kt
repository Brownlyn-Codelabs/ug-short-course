package io.codelabs.todoapplication.ui.adapter

import android.content.Context
import android.content.Intent
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.codelabs.todoapplication.R
import io.codelabs.todoapplication.data.TodoItem
import io.codelabs.todoapplication.ui.DetailsActivity
import kotlinx.android.synthetic.main.item_todo.view.*
import kotlinx.android.synthetic.main.item_todo_completed.view.*

/**
 * This populates the recyclerview with items from the todoList
 */
class TodoTaskAdapter constructor(private val ctx: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_EMPTY = 0
        private const val TYPE_ITEMS = 1
        private const val TYPE_ITEMS_COMPLETED = 2
    }

    private val dataset: MutableList<TodoItem> = ArrayList<TodoItem>(0)

    override fun getItemViewType(position: Int): Int = when {
        dataset.isEmpty() -> TYPE_EMPTY
        dataset[position].completed -> TYPE_ITEMS_COMPLETED
        else -> TYPE_ITEMS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEMS -> TodoViewHolder(
                LayoutInflater.from(ctx).inflate(
                    R.layout.item_todo, parent,
                    false
                )
            )

            TYPE_ITEMS_COMPLETED -> TodoViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_todo_completed,
                    parent,
                    false
                )
            )

            else -> EmptyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item_empty, parent, false))
        }
    }

    override fun getItemCount(): Int = if (dataset.isEmpty()) 1 else dataset.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_ITEMS_COMPLETED -> {
                if (holder is TodoViewHolder) {
                    val todoItem = dataset[position]
                    holder.view.completed_todo_item_title.text = todoItem.content
                    holder.view.completed_todo_item_timestamp.text = DateUtils.getRelativeTimeSpanString(
                        todoItem.timestamp,
                        System.currentTimeMillis(),
                        DateUtils.SECOND_IN_MILLIS
                    )
                }
            }

            TYPE_ITEMS -> {
                if (holder is TodoViewHolder) {
                    val todoItem = dataset[position]
                    holder.view.todo_item_title.text = todoItem.content
                    holder.view.todo_item_timestamp.text =
                        DateUtils.getRelativeTimeSpanString(
                            todoItem.timestamp,
                            System.currentTimeMillis(),
                            DateUtils.SECOND_IN_MILLIS
                        )

                    // Pass data between activities
                    holder.view.setOnClickListener {
                        // Create intent object
                        val intent = Intent(ctx, DetailsActivity::class.java)

                        // Add data to intent
                        intent.putExtra(/*key*/DetailsActivity.EXTRA_ITEM,/*value*/todoItem)

                        // Start activity with intent object
                        ctx.startActivity(intent)
                    }
                }
            }

            else -> {
                /*Do nothing for empty view*/
            }
        }
    }

    /**
     * Add new [items] to the existing list
     */
    fun addItems(items: MutableList<TodoItem>) {
        clear()
        dataset.addAll(items)
        notifyDataSetChanged()
    }

    private fun clear() = dataset.clear()
}