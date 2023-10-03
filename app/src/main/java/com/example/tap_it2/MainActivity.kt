package com.example.tap_it2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tap_it.Display
import com.example.tap_it.generateRandomColor
import com.example.tap_it.ui.theme.Tap_ItTheme
import com.example.tap_it2.App


 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}