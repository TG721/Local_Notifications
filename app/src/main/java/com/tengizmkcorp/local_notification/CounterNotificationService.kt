package com.tengizmkcorp.local_notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context,
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0

        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationBroadcast::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_donut_large_24)
            .setContentTitle("Increment counter")
            .setContentText("The count is $counter")
//            .setStyle()
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_baseline_smart_button_24,
                "Increment",
                incrementIntent
            )
//            .setOngoing() //user would not be able to swipe it away
            .build()

        notificationManager.notify( //function that will show notification
            1, //to update notification we need to use same id, since we only have one notification. 1 will do
            notification
        )
    }

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"

    }
}