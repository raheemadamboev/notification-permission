package xyz.teamgravity.notificationpermission.presentation.screen

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import xyz.teamgravity.notificationpermission.R
import xyz.teamgravity.notificationpermission.presentation.viewmodel.HelloViewModel

@Composable
fun HelloScreen(
    permission: PermissionState = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS),
    viewmodel: HelloViewModel = hiltViewModel(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(id = if (permission.status.isGranted) R.string.you_have_granted_permission else R.string.you_need_grant_permission))
        if (!permission.status.isGranted) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { permission.launchPermissionRequest() }) {
                Text(text = stringResource(id = R.string.grant_permission))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = viewmodel::onGreet) {
            Text(text = stringResource(id = R.string.greet))
        }
    }
}