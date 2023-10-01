package com.example.tap_it

import androidx.compose.ui.graphics.Color

class OnClick(
    var restart: Boolean,
    var current: Int,
    var selectedColor: Color,
    var levels: MutableMap<Int, Color>,
    var level: Int
) {
    fun onClick(){
        if (!Check(selectedColor, levels, current)) {
            restart = true
        } else if (current == level && Check(
                selectedColor,
                levels,
                current
            )
        ) {
            current = 1
            level++
        } else if (Check(selectedColor, levels, current)) {
            val size = levels.size + 1
            levels[size] = generateRandomColor()
            current++
        }
    }
}