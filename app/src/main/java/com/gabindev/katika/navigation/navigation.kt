package com.gabindev.katika.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabindev.katika.components.AppFloatingActionButton
import com.gabindev.katika.providers.LocalDrawerState
import com.gabindev.katika.views.History
import com.gabindev.katika.views.Home
import com.gabindev.katika.views.Setting
import kotlinx.coroutines.launch


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(drawerState: DrawerState = LocalDrawerState.current) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerNavigation(onNavigate = { route ->
                navController.navigate((route))
                coroutineScope.launch {
                    drawerState.close()
                }
            })
        },
    ) {

        Scaffold(
            floatingActionButton = { AppFloatingActionButton(navController) }
        ) {
            Surface {
                NavHost(
                    navController,
                    startDestination = Route.HOME,
                    Modifier.padding(it)
                ) {
                    composable(Route.HOME) { Home() }
                    composable(Route.SETTING) { Setting() }
                    composable(Route.HISTORY) { History() }
                }
            }
        }
    }
}