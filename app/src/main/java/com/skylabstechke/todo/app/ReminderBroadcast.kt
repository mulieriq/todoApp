package com.skylabstechke.todo.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.skylabstechke.todo.R
import java.util.*

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        var builder = NotificationCompat.Builder(context, Calendar.getInstance().timeInMillis.toInt().toString())
            .setSmallIcon(R.drawable.ic_save)
            .setContentTitle("Reminder")
            .setContentText("changamka")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        NotificationManagerCompat.from(context).apply {
            notify(200, builder.build())
        }


    }
}