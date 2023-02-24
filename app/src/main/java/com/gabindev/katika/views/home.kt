package com.gabindev.katika.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gabindev.katika.components.home.HomeBottomSheet
import com.gabindev.katika.components.home.ListTimes

@Composable
fun Home() {
    Column(Modifier.fillMaxWidth()) {
        ListTimes()
        HomeBottomSheet()
    }
}