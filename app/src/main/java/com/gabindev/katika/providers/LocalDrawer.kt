package com.gabindev.katika.providers

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.compositionLocalOf

@OptIn(ExperimentalMaterial3Api::class)
val LocalDrawerState  = compositionLocalOf { DrawerState(initialValue = DrawerValue.Closed) }