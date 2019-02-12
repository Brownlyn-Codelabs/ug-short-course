package io.codelabs.chatapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.Message
import io.codelabs.chatapplication.data.User
import io.codelabs.chatapplication.glide.GlideApp
import io.codelabs.chatapplication.util.*
import io.codelabs.chatapplication.view.adapter.MessagesAdapter
import kotlinx.android.synthetic.main.activity_messaging.*

class MessagingActivity(override val layoutId: Int = R.layout.activity_messaging) : BaseActivity(),
    MessagesAdapter.OnItemClickListener {


    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {
        //setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finishAfterTransition() }

        if (intent.hasExtra(ProfileActivity.EXTRA_USER)) {
            bindUser(intent.getParcelableExtra(EXTRA_USER))
        } else if (intent.hasExtra(EXTRA_USER_ID)) {
            loadUserById(intent.getStringExtra(EXTRA_USER_ID))
        }
    }

    private fun loadUserById(id: String?) {
        if (id.isNullOrEmpty()) return
        firestore.document(String.format(USER_DOC_REF, id))
            .addSnapshotListener(this@MessagingActivity) { snapshot, exception ->
                if (exception != null) {
                    debugLog(exception.localizedMessage)
                    toast("Cannot load current user's profile")
                    return@addSnapshotListener
                }

                // Get user from snapshot and bind the data to the UI
                val user = snapshot?.toObject(User::class.java)
                bindUser(user)
            }
    }


    private fun bindUser(user: User?) {
        if (user == null) {
            toast("Cannot load user's profile")
            return
        }

        debugLog(user)

        // Setup user data
        toolbar_title.text = user.name

        GlideApp.with(this)
            .asBitmap()
            .load(user.profile)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.avatar_placeholder)
            .error(R.drawable.avatar_placeholder)
            .transition(BitmapTransitionOptions.withCrossFade())
            .into(avatar)

        avatar.setOnClickListener {
            val bundle = Bundle(0)
            bundle.putString(PreviewActivity.EXTRA_URL, user.profile)
            intentTo(PreviewActivity::class.java, bundle)
        }

        fetchMessages(user.key)

    }

    private fun fetchMessages(key: String) {
        val adapter = MessagesAdapter(this, this)
        message_grid.adapter = adapter
        message_grid.layoutManager = LinearLayoutManager(this)
        message_grid.setHasFixedSize(true)
        message_grid.itemAnimator = DefaultItemAnimator()

        firestore.collection(String.format(USER_MESSAGES_DOC_REF, database.key, key))
            .addSnapshotListener(this@MessagingActivity) { snapshot, exception ->
                if (exception != null) {
                    debugLog(exception.cause)
                    toast("Unable to retrieve messages")
                    return@addSnapshotListener
                }

                // Load message from snapshot and append to UI
                val messages = snapshot?.toObjects(Message::class.java)
                if (messages != null) adapter.addData(messages.toMutableList())

            }
    }

    fun sendMessage(v: View?) {}

    fun addFile(v: View?) {}

    override fun onClick(item: Message) {

    }

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_USER_ID = "EXTRA_USER_ID"
    }
}