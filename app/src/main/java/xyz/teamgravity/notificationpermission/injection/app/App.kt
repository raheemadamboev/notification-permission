package xyz.teamgravity.notificationpermission.injection.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import xyz.teamgravity.notificationpermission.core.notification.HelloNotification
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var notification: HelloNotification

    override fun onCreate() {
        super.onCreate()

        notification.createChannel()
    }
}