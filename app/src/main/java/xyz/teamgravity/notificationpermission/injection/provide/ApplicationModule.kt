package xyz.teamgravity.notificationpermission.injection.provide

import android.app.Application
import android.app.NotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.notificationpermission.core.notification.HelloNotification
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideNotificationManager(application: Application): NotificationManager =
        application.getSystemService(NotificationManager::class.java)

    @Provides
    @Singleton
    fun provideHelloNotification(
        application: Application,
        notificationManager: NotificationManager,
    ): HelloNotification = HelloNotification(
        context = application,
        manager = notificationManager
    )
}