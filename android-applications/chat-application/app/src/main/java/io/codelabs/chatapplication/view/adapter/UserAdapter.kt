package io.codelabs.chatapplication.view.adapter

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.BaseDataModel
import io.codelabs.chatapplication.data.User
import io.codelabs.chatapplication.glide.GlideApp
import io.codelabs.chatapplication.util.BaseActivity
import io.codelabs.chatapplication.util.intentTo
import io.codelabs.chatapplication.view.PreviewActivity
import io.codelabs.chatapplication.view.ProfileActivity
import kotlinx.android.synthetic.main.item_chat.view.*
import kotlinx.android.synthetic.main.item_empty.view.*

class UserAdapter constructor(private val host: BaseActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_EMPTY = -1
        private const val TYPE_DATA = 0
    }

    private val dataset: MutableList<in BaseDataModel> = ArrayList<BaseDataModel>(0)

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
                val item = dataset[position]

                when (item) {
                    is User -> {
                        if (holder is ChatViewHolder) {
                            val avatar = holder.view.user_avatar
                            val username = holder.view.user_name
                            val lastSeen = holder.view.user_last_seen
                            val status = holder.view.user_status

                            // Load profile image
                            GlideApp.with(avatar.context)
                                .asBitmap()
                                .load(item.profile)
                                .circleCrop()
                                .placeholder(R.drawable.avatar_placeholder)
                                .error(R.drawable.avatar_placeholder)
                                .fallback(R.drawable.avatar_placeholder)
                                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                                .transition(withCrossFade())
                                .into(avatar)

                            // Set other properties
                            username.text = item.name
                            status.text = item.status
                            lastSeen.text = DateUtils.getRelativeTimeSpanString(
                                item.lastSeen,
                                System.currentTimeMillis(),
                                DateUtils.SECOND_IN_MILLIS
                            )

                            avatar.setOnClickListener {
                                val bundle = Bundle(0)
                                bundle.putString(PreviewActivity.EXTRA_URL, item.profile)
                                host.intentTo(PreviewActivity::class.java, bundle)
                            }

                            holder.view.setOnClickListener {
                                val bundle = Bundle(0)
                                bundle.putParcelable(ProfileActivity.EXTRA_USER, item)
                                host.intentTo(ProfileActivity::class.java, bundle)
                            }
                        }
                    }
                }
            }

            else -> {
                GlideApp.with(host)
                    .asGif()
                    .load(R.drawable.empty_state)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into((holder as EmptyViewHolder).view.empty_view)
            }
        }
    }

    fun addData(items: MutableList<out BaseDataModel>) {
        dataset.clear()
        for (item in items) {
            dataset.add(item)
            notifyItemRangeChanged(0, items.size)
        }
    }
}