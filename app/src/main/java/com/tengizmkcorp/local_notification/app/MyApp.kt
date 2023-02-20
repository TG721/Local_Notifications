package com.tengizmkcorp.local_notification.app

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.tengizmkcorp.local_notification.CounterNotificationService

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CounterNotificationService.COUNTER_CHANNEL_ID, //id
                "Counter", //name
                 NotificationManager.IMPORTANCE_DEFAULT //importance
            )
            channel.description = "Used for the increment counter notifications"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }
}