package com.example.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel:MainActivityViewModel
    private lateinit var value: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button =findViewById(R.id.button)

        mainActivityViewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val count: LiveData<Int> = mainActivityViewModel.getInitialcount()
        count.observe(this, Observer {
            value = it.toString()
        })

        button.setOnClickListener {
            mainActivityViewModel.getCurrentCount()
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("message_key", value)
            startActivity(intent)
        }
    }
}