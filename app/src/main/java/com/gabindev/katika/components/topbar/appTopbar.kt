package com.gabindev.katika.components.topbar

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    CenterAlignedTopAppBar(
        navigationIcon = {
            NavigationIcon()
        },
        title = {
            Title()
        },
        actions = {
            ActionMenu()
        }
    )
}


@Composable()
@Preview(showBackground = true)
fun PreviewTopBar() {
    AppTopBar()
}