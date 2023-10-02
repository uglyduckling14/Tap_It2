package com.example.tap_it2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tap_it2.MainScreen
import com.example.tap_it.ui.theme.Tap_ItTheme
import com.example.tap_it2.ui.navigation.RootNavigation

@Composable
fun App(){
    Tap_ItTheme {
        // A surface container using the 'background' color from the theme
        //MainScreen()
        RootNavigation()
    }
}

