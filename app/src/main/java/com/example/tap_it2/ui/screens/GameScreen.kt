package com.example.tap_it2.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.tap_it.Display
import com.example.tap_it.generateRandomColor
import com.example.tap_it2.ui.components.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel){
    val levels = mutableMapOf(
        1 to generateRandomColor(),
        2 to generateRandomColor()
    )
    Display(levels,navController)
}