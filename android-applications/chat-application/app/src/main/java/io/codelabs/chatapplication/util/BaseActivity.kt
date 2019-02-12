package io.codelabs.chatapplication.util

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Base class for all activities
 */
abstract class BaseActivity : AppCompatActivity() {
    private val job = Job()
    protected val ioScope = CoroutineScope(Dispatchers.IO + job)
    protected val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        debugLog("ActivityID: ${this::class.java.name}")

        onViewCreated(savedInstanceState, intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    abstract val layoutId: Int

    abstract fun onViewCreated(instanceState: Bundle?, intent: Intent)

}