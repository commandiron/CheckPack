package com.commandiron.vacationchecklist.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.commandiron.vacationchecklist.R

class NotificationService(
    private val context: Context
) {
    fun showNotification(){
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(NotificationAttr.title)
            .setContentText(NotificationAttr.desc)
            .setSmallIcon(R.drawable.checkpack_logo)
            .build()
        notificationManager.notify(1, notification)
    }

    companion object{
        const val CHANNEL_ID = "channel_id"
        const val CHANNEL_NAME = "channel_name"
    }
}

object NotificationAttr {
    var title: String = ""
    var desc: String = ""
}