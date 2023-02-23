package com.gabindev.katika.components.home


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

internal data class Btn(var id: Int, var title: String)

internal const val LENGTH = 2
internal val BUTTONS = listOf(Btn(1, "01 Joueur"), Btn(2, "02 Joueurs"))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupButtons(onSelect: (value: Int) -> Unit = {}) {
    val checked = remember { mutableStateOf(1) }

    Row {
        repeat(LENGTH) {
            AssistChip(
                onClick = {
                    checked.value = BUTTONS[it].id
                    onSelect.invoke(BUTTONS[it].id)
                },
                label = {
                    Text(
                        BUTTONS[it].title,
                        Modifier.padding(
                            vertical = 12.dp,
                            horizontal = if (checked.value != BUTTONS[it].id) {
                                12.dp
                            } else {
                                0.dp
                            }
                        ),
                        fontSize = 15.sp
                    )
                },
                leadingIcon = {
                    AnimatedVisibility(visible = checked.value == BUTTONS[it].id) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "checked"
                        )
                    }
                },
                shape = RoundedCornerShape(
                    topStart = if (it == 0) {
                        20.dp
                    } else {
                        0.dp
                    },
                    bottomStart = if (it == 0) {
                        20.dp
                    } else {
                        0.dp
                    },
                    topEnd = if (it == LENGTH - 1) {
                        20.dp
                    } else {
                        0.dp
                    },
                    bottomEnd = if (it == LENGTH - 1) {
                        20.dp
                    } else {
                        0.dp
                    }
                ),
                colors = if (checked.value == BUTTONS[it].id) {
                    AssistChipDefaults.assistChipColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface)
                } else {
                    AssistChipDefaults.assistChipColors()
                }
            )
        }

    }
}