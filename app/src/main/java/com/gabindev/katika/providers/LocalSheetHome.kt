package com.gabindev.katika.providers

import androidx.compose.runtime.compositionLocalOf
import com.dokar.sheets.BottomSheetState
import com.dokar.sheets.BottomSheetValue

val LocalSheetHome  = compositionLocalOf { BottomSheetState(initialValue = BottomSheetValue.Collapsed)}