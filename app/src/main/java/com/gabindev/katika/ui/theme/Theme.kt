package com.gabindev.katika.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

@Composable
fun KatikaTheme(useDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorSchemaColors = when {
        dynamicColor && useDarkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !useDarkTheme -> dynamicLightColorScheme(LocalContext.current)
        useDarkTheme -> DarkColor
        else -> LightColor
    }

    MaterialTheme(
        colorScheme = colorSchemaColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}