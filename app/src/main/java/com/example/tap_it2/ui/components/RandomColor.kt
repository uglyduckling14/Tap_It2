package com.example.tap_it

import android.graphics.Color.BLUE
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.graphics.Color.YELLOW
import kotlin.random.Random


fun generateRandomColor(): Int {
    val random = Random.Default

    val allowedColors = arrayOf(
        RED,
        GREEN,
        BLUE,
        YELLOW
    )

    val randomIndex = random.nextInt(allowedColors.size)

    return allowedColors[randomIndex]
}
