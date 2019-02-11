package io.codelabs.todoapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.codelabs.todoapplication.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


    }

    companion object {
        const val EXTRA_ITEM = "EXTRA_ITEM"
    }
}