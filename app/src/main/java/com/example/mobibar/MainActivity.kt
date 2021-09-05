package com.example.mobibar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView2: TextView= findViewById(R.id.textView2)
        val text: String = "I undertake that i am of Legal drinking age at the location where I intend to use MobiBar: The mobile bar app and agree to its T&C's. I confirm that my device is not a shared device and authorise MobiBar to send OTP to my number and to display pricing, content and catalog information relating to alcoholic beverages in MobiBar licence for my use"
        textView2.text = text
        textView2.movementMethod = ScrollingMovementMethod()

        val button: Button = findViewById(R.id.agree)
        button.setOnClickListener {
            intent= Intent(this, NavDrawerActivity::class.java)
            startActivity(intent)
        }
    }

}