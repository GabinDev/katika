package com.gabindev.katika

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.view.WindowCompat
import com.gabindev.katika.components.AppLayout
import com.gabindev.katika.navigation.AppNavigation
import com.gabindev.katika.ui.theme.KatikaTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KatikaTheme {
                AppLayout {
                    AppNavigation()
                }
            }
        }
    }
}