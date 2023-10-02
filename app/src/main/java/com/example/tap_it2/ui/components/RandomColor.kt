package com.example.tap_it

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


fun generateRandomColor(): Color {
    val random = Random.Default

    val allowedColors = arrayOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow
    )

    val randomIndex = random.nextInt(allowedColors.size)

    return allowedColors[randomIndex]
}
