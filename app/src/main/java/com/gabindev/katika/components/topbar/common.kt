package com.gabindev.katika.components.topbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gabindev.katika.providers.LocalDrawerState
import kotlinx.coroutines.launch

@Composable
fun Title(text: String = "") {
    Text(
        text,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.fillMaxWidth()
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationIcon(drawer: DrawerState = LocalDrawerState.current) {
    val coroutineScope = rememberCoroutineScope()

    IconButton(onClick = {
        coroutineScope.launch {
            if (drawer.isClosed) {
                drawer.open()
            } else {
                drawer.close()
            }
        }
    }) {
        Column {
            AnimatedVisibility(visible = drawer.isClosed) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "drawer",
                    modifier = Modifier.size(30.dp),
                )
            }
            AnimatedVisibility(visible = drawer.isOpen) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "drawer",
                    modifier = Modifier.size(30.dp),
                )
            }
        }
    }
}


@Composable
fun ActionMenu() {
    val expanded = remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded.value = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "menu")
        }
        TopBarMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false })
    }
}

