package xyz.teamgravity.notificationpermission.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.teamgravity.notificationpermission.core.notification.HelloNotification
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(
    private val notification: HelloNotification,
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onGreet() {
        notification.show()
    }
}