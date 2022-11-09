package xyz.teamgravity.notificationpermission.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import xyz.teamgravity.notificationpermission.R

class HelloNotification(
    private val context: Context,
    private val manager: NotificationManager,
) {

    companion object {
        private const val ID = 1
        private const val CHANNEL_ID = "channel_id"
    }

    fun show() {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(R.string.hello))
            .setContentText(context.getString(R.string.hello_name))
            .build()
        manager.notify(ID, notification)
    }

    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(CHANNEL_ID, context.getString(R.string.hello_name), NotificationManager.IMPORTANCE_HIGH).apply {
                description = context.getString(R.string.hello_description)
                manager.createNotificationChannel(this)
            }
        }
    }
}