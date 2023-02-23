package com.gabindev.katika.components.topbar

import android.app.Activity
import androidx.activity.compose.LocalActivityResultRegistryOwner
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun TopBarMenu(expanded: Boolean = false, onDismissRequest: () -> Unit) {
    val activity = LocalContext.current as Activity
    DropdownMenu(expanded, onDismissRequest) {
        DropdownMenuItem(
            onClick = { activity.finish() },
            text = { Text("Quitter") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "exit")
            }
        )
    }
}