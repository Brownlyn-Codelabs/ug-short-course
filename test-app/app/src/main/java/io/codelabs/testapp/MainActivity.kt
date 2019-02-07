package io.codelabs.testapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowCount.setOnClickListener {
            handleClick()
        }

    }

    /*private*/ fun handleClick() {
        // Create a variable to show the number of clicks on the button
        var count = 0

        // count += 1
        count = count.plus(1)
        if (count == 1) {
            textShowCount.text = "You clicked the button once"
        } else {
            textShowCount.text = "You clicked the button $count times"
        }
    }
}
