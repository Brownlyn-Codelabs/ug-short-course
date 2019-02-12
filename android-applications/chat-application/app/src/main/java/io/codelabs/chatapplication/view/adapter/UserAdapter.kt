package io.codelabs.chatapplication.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.BaseDataModel

class UserAdapter constructor(private val host: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_EMPTY = -1
        private const val TYPE_DATA = 0
    }

    private val dataset: MutableList<in BaseDataModel> = ArrayList(0)

    override fun getItemViewType(position: Int): Int = if (dataset.isEmpty()) TYPE_EMPTY else TYPE_DATA

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EMPTY -> EmptyViewHolder(LayoutInflater.from(host).inflate(R.layout.item_empty, parent, false))
            else -> ChatViewHolder(LayoutInflater.from(host).inflate(R.layout.item_chat, parent, false))
        }
    }

    override fun getItemCount(): Int = if (dataset.isEmpty()) 1 else dataset.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_DATA -> {

            }

            else -> {

            }
        }
    }
}