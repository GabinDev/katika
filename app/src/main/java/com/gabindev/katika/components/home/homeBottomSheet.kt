package com.gabindev.katika.components.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dokar.sheets.BottomSheet
import com.dokar.sheets.BottomSheetState
import com.gabindev.katika.providers.LocalSheetHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBottomSheet(sheetHome: BottomSheetState = LocalSheetHome.current) {

    val name = remember { mutableStateOf("") }

    BottomSheet(
        state = sheetHome,
        backgroundColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.padding(horizontal = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 20.dp)
                .padding(horizontal = 20.dp),
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nom du poste") }
            )

            GroupButtons()

            ElevatedButton(
                onClick = { },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                content = {
                    Text(text = "Démarrer")
                }
            )
        }
    }
}