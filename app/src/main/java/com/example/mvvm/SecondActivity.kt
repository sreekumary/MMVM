package com.example.mvvm

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    lateinit var receiver_msg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        receiver_msg = findViewById(R.id.received_value_id)
        val intent = intent
        val str = intent.getStringExtra("message_key")
        receiver_msg.text = str
    }
}