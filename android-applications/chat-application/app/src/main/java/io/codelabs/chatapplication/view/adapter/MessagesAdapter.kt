package io.codelabs.chatapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.Message
import io.codelabs.chatapplication.glide.GlideApp
import io.codelabs.chatapplication.util.BaseActivity
import io.codelabs.chatapplication.util.toast
import kotlinx.android.synthetic.main.item_empty.view.*

class MessagesAdapter(private val host: BaseActivity, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_EMPTY = -1
        private const val TYPE_MESSAGE_TEXT = 0
        private const val TYPE_MESSAGE_OTHER = 1
    }

    private val dataset: MutableList<Message> = ArrayList<Message>(0)

    override fun getItemViewType(position: Int): Int {
        return when {
            dataset.isEmpty() -> TYPE_EMPTY
            dataset.isNotEmpty() && dataset[position].type == Message.TYPE_TEXT -> TYPE_MESSAGE_TEXT
            else -> TYPE_MESSAGE_OTHER
        }
    }

    override fun getItemId(position: Int): Long =
        if (dataset.isEmpty()) RecyclerView.NO_ID else dataset[position].hashCode().toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EMPTY -> EmptyViewHolder(
                LayoutInflater.from(host).inflate(R.layout.item_empty, parent, false)
            )

            TYPE_MESSAGE_OTHER -> MessageViewHolder(
                LayoutInflater.from(host).inflate(R.layout.item_message_media, parent, false)
            )

            else -> MessageViewHolder(
                LayoutInflater.from(host).inflate(R.layout.item_message_text, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = if (dataset.isEmpty()) 1 else dataset.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_EMPTY -> {
                if (holder is EmptyViewHolder) {
                    GlideApp.with(host)
                        .asBitmap()
                        .load(R.drawable.empty_chat)
                        .into(holder.view.empty_view)
                }
            }

            TYPE_MESSAGE_OTHER -> {
                if (holder is MessageViewHolder) {
                    val message = dataset[position]

                    holder.view.setOnClickListener {
                        host.toast(message)
                    }

                }
            }

            TYPE_MESSAGE_TEXT -> {
                if (holder is MessageViewHolder) {
                    val message = dataset[position]

                    holder.view.setOnClickListener {
                        host.toast(message)
                    }
                }
            }
        }
    }

    fun addData(items: MutableList<Message>) {
        dataset.clear()
        dataset.addAll(items)
        notifyDataSetChanged()
    }


    interface OnItemClickListener {
        fun onClick(item: Message)
    }

}