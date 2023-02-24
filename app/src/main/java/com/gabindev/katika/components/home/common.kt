package com.gabindev.katika.components.home

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter


@Composable
internal fun ClickableIcon(painter: Painter, onClick: () -> Unit) {
    IconButton(onClick = { onClick() }) {
        Icon(
            painter,
            "icon clickable",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}