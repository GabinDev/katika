package com.gabindev.katika.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gabindev.katika.R

data class NavItem(val icon: ImageVector, val name: String, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerNavigation(onNavigate: (route: String) -> Unit) {
    val navItems = listOf(
        NavItem(icon = Icons.Default.Home, name = "Acceuil", route = Route.HOME),
        NavItem(
            icon = ImageVector.vectorResource(R.drawable.outline_history_24),
            name = "Historique",
            route = Route.HISTORY
        ),
        NavItem(icon = Icons.Default.Settings, name = "Paramètre", route = Route.SETTING)
    )
    val selected = remember { mutableStateOf(navItems[0]) }

    ModalDrawerSheet(
        drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
    ) {
        navItems.forEach { navItem ->
            NavigationDrawerItem(
                modifier = Modifier.padding(horizontal = 5.dp),
                label = {
                    Text(
                        navItem.name,
                        fontWeight = if (selected.value.name === navItem.name) {
                            selected.value.name === navItem.name
                            FontWeight.Medium
                        } else {
                            FontWeight.Normal
                        }
                    )
                },
                selected = selected.value.name === navItem.name,
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.name) },
                onClick = {
                    selected.value = navItem
                    onNavigate(navItem.route)
                }
            )
        }
    }
}