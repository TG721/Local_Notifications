package com.tengizmkcorp.local_notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = CounterNotificationService(applicationContext)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            service.showNotification(Counter.value)
        }
    }
}