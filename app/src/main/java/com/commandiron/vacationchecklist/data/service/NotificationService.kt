package com.commandiron.vacationchecklist.data.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.Canvas
import android.os.Build
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
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
            .setLargeIcon(context.vectorToBitmap(R.drawable.checkpack_logo))
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setColor(ContextCompat.getColor(context,R.color.notificationColor))
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

fun Context.vectorToBitmap(drawableId: Int): Bitmap? {
    val drawable = AppCompatResources.getDrawable(this, drawableId) ?: return null
    val bitmap = createBitmap(
        drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
    ) ?: return null
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}