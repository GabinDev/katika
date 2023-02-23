package com.gabindev.katika.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gabindev.katika.components.topbar.AppTopBar


@Composable
fun AppLayout(appNavigation: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar()
        appNavigation()
    }
}