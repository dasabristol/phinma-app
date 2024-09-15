package com.example.management_app

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Notification
import android.os.Build
import androidx.core.app.NotificationCompat

class ReminderReceiver : BroadcastReceiver() {

    @SuppressLint("NotificationPermission")
    override fun onReceive(context: Context, intent: Intent) {
        val eventTitle = intent.getStringExtra("eventTitle") ?: "No Event"

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationId = (System.currentTimeMillis() % 10000).toInt() // Unique ID for each notification

        val notificationBuilder = NotificationCompat.Builder(context, "event_channel_id")
            .setSmallIcon(R.drawable.eventcalendar) // Change this to your notification icon
            .setContentTitle("Event Reminder")
            .setContentText("Event: $eventTitle")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "event_channel_id",
                "Event Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(notificationId, notificationBuilder.build())
    }
}
