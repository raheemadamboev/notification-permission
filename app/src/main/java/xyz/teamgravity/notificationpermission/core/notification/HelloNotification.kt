package xyz.teamgravity.notificationpermission.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
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

    private fun areNotificationsEnabled(): Boolean {
        return manager.areNotificationsEnabled()
    }

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun show() {
        if (areNotificationsEnabled()) {
            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(context.getString(R.string.hello))
                .setContentText(context.getString(R.string.hello_raheem))
                .build()
            manager.notify(ID, notification)
        }
    }

    fun createChannel() {
        NotificationChannel(CHANNEL_ID, context.getString(R.string.hello_name), NotificationManager.IMPORTANCE_HIGH).apply {
            description = context.getString(R.string.hello_description)
            manager.createNotificationChannel(this)
        }
    }
}