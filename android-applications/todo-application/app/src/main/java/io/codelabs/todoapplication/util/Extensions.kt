package io.codelabs.todoapplication.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import io.codelabs.todoapplication.R

/**
 * prints a message of [Any] object to the console
 */
fun debugLog(msg: Any?) = println("Todo Application -> ${msg.toString()}")

fun Context.toast(message: Any? = "", @StringRes resId: Int = R.string.empty_text) = Toast.makeText(
    this,
    if (message.toString().isEmpty()) getString(resId) else message.toString(),
    Toast.LENGTH_LONG
).show()

