package com.commandiron.vacationchecklist.domain.use_cases

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.commandiron.vacationchecklist.AlarmReceiver
import com.commandiron.vacationchecklist.service.NotificationAttr
import java.util.*

class SetAlarm(
    private val context: Context
) {
    operator fun invoke(
        notificationTitle: String,
        notificationDesc: String,
        alarmTime: Date
    ){
        NotificationAttr.title = notificationTitle
        NotificationAttr.desc = notificationDesc

        val timeSec = System.currentTimeMillis() + 3000

        val alarmManager = context.getSystemService(Application.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) PendingIntent.FLAG_IMMUTABLE else 0
        )
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeSec, pendingIntent)
    }
}