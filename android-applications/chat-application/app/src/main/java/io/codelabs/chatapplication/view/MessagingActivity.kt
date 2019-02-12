package io.codelabs.chatapplication.view

import android.content.Intent
import android.os.Bundle
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.util.BaseActivity

class MessagingActivity(override val layoutId: Int = R.layout.activity_messaging) : BaseActivity() {


    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {

    }

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_USER_ID = "EXTRA_USER_ID"
    }
}