package com.gabindev.katika.components

import android.os.Bundle
import androidx.compose.animation.*
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.dokar.sheets.BottomSheetState
import com.gabindev.katika.navigation.Route
import com.gabindev.katika.providers.LocalSheetHome
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppFloatingActionButton(
    navController: NavController,
    sheetHome: BottomSheetState = LocalSheetHome.current
) {
    val route = remember { mutableStateOf(navController.currentDestination?.route.toString()) }
    val coroutineScope = rememberCoroutineScope()

    navController.addOnDestinationChangedListener { _: NavController, navDestination: NavDestination, _: Bundle? ->
        run {
            route.value = navDestination.route.toString()
        }
    }

    AnimatedVisibility(
        visible = route.value === Route.HOME,
        enter = scaleIn(animationSpec = spring(dampingRatio = 0.5f)) + fadeIn(),
        exit = scaleOut()
    ) {
        Box(modifier = Modifier.padding(end = 5.dp, bottom = 5.dp)) {
            FloatingActionButton(
                onClick = { coroutineScope.launch { sheetHome.expand() } },
                shape = RoundedCornerShape(10.dp),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    }
}