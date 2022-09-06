package com.commandiron.vacationchecklist.domain.use_cases

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.commandiron.vacationchecklist.data.broadcast_receiver.AlarmReceiver
import com.commandiron.vacationchecklist.data.service.NotificationAttr
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class SetAlarm(
    private val context: Context
) {
    operator fun invoke(
        notificationTitle: String,
        notificationDesc: String,
        time: LocalDateTime
    ) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationAttr.title = notificationTitle
            NotificationAttr.desc = notificationDesc
            val alarmTime =
                System.currentTimeMillis() +
                        ChronoUnit.MILLIS.between(
                            LocalDateTime.now(), time
                        )

            val intent = Intent(context, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) PendingIntent.FLAG_IMMUTABLE else 0
            )

            val alarmManager = context.getSystemService(Application.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent)
        }
    }
}