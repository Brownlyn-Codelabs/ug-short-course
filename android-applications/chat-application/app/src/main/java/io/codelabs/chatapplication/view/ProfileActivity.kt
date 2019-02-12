package io.codelabs.chatapplication.view

import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.data.User
import io.codelabs.chatapplication.glide.GlideApp
import io.codelabs.chatapplication.util.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity(override val layoutId: Int = R.layout.activity_profile) : BaseActivity() {

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finishAfterTransition() }

        if (intent.hasExtra(EXTRA_USER)) {
            bindUser(intent.getParcelableExtra(EXTRA_USER))
        } else if (intent.hasExtra(EXTRA_USER_ID)) {
            loadUserById(intent.getStringExtra(EXTRA_USER_ID))
        }
    }

    private fun loadUserById(id: String?) {
        if (id.isNullOrEmpty()) return
        firestore.document(String.format(USER_DOC_REF, id))
            .addSnapshotListener(this@ProfileActivity) { snapshot, exception ->
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
        user_status.text = user.status

        GlideApp.with(this)
            .asBitmap()
            .load(user.profile)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.avatar_placeholder)
            .error(R.drawable.avatar_placeholder)
            .transition(withCrossFade())
            .into(avatar)

        avatar.setOnClickListener {
            val bundle = Bundle(0)
            bundle.putString(PreviewActivity.EXTRA_URL, user.profile)
            intentTo(PreviewActivity::class.java, bundle)
        }

    }

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_USER_ID = "EXTRA_USER_ID"
    }
}