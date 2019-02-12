package io.codelabs.chatapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.core.ChatApplication
import io.codelabs.chatapplication.room.factory.UserViewModelFactory
import io.codelabs.chatapplication.room.viewmodel.UserViewModel
import io.codelabs.chatapplication.util.BaseActivity
import io.codelabs.chatapplication.util.debugLog
import io.codelabs.chatapplication.util.intentTo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity() {

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {

        // View Model instance
        val viewModel = ViewModelProviders.of(this, UserViewModelFactory(application as ChatApplication))
            .get(UserViewModel::class.java)

        viewModel.getAllUsers().observe(this@MainActivity, Observer {
            uiScope.launch {
                debugLog(it)
            }
        })

        get_started.setOnClickListener {
            intentTo(AuthActivity::class.java, true)
        }

    }

}
