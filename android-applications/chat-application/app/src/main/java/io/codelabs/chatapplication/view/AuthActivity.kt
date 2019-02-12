package io.codelabs.chatapplication.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import io.codelabs.chatapplication.R
import io.codelabs.chatapplication.util.BaseActivity
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.coroutines.launch

/**
 * Activity to handle [User] authentication
 */
class AuthActivity(override val layoutId: Int = R.layout.activity_auth) : BaseActivity() {

    override fun onViewCreated(instanceState: Bundle?, intent: Intent) {
        username.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)

        login_button.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        val usr = username.text.toString()
        val pwd = password.text.toString()

        ioScope.launch {

        }


    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            login_button.isEnabled = setButtonState()
        }
    }

    private fun setButtonState(): Boolean {
        val usr = username.text.toString()
        val pwd = password.text.toString()

        // Username is not empty
        // Password is not empty
        // Username matches email address format
        // Password length is not less than 6
        return usr.isNotEmpty() && pwd.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(usr).matches() && pwd.length > 5
    }
}