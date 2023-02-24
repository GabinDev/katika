package com.gabindev.katika.components.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.marosseleng.compose.material3.datetimepickers.time.domain.noSeconds
import com.marosseleng.compose.material3.datetimepickers.time.ui.TimePicker
import java.time.LocalTime
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTime() {
    TimePicker(
        initialTime = LocalTime.now().noSeconds(),
        onTimeChange = {},
        is24HourFormat = true,
        locale = Locale.FRANCE,
        title = { }
    )
}