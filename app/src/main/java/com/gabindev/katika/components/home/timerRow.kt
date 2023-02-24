package com.gabindev.katika.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabindev.katika.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimerRow() {
    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
    modifier = Modifier
        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = "Poste-1", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = "(1h PS4)",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Italic
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.joystick),
                        contentDescription = "game",
                        tint = MaterialTheme.colorScheme.inverseSurface
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.joystick),
                        contentDescription = "game",
                        tint = MaterialTheme.colorScheme.inverseSurface
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "00:00",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.inverseSurface
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ClickableIcon(painter = painterResource(R.drawable.filled_stop), onClick = {})
                    ClickableIcon(painter = painterResource(R.drawable.filled_pause), onClick = {})
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(horizontal = 10.dp)
            ) {
                ElevatedAssistChip(
                    onClick = { },
                    leadingIcon = { Icon(painterResource(R.drawable.add), "add") },
                    label = { Text(text = "30min", color = MaterialTheme.colorScheme.primary) }
                )
                ElevatedAssistChip(
                    onClick = { },
                    leadingIcon = { Icon(painterResource(R.drawable.add), "add") },
                    label = { Text(text = "1h", color = MaterialTheme.colorScheme.primary) }
                )
            }
        }
    }
}