package com.example.tap_it

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

//Four boxes to be clicked
@Composable
fun Boxes(boxColors: MutableList<Boolean>): Color{
    var selectedColor = Color.White
    Row(
        modifier = Modifier
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .background(Color.White)
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .weight(1f)
                    .clickable {
                        boxColors[0] = !boxColors[0]
                        selectedColor = Color.Red
                        println(selectedColor)
                        //when clicked, give the red color + the level number and add it to the selected dictionary and compare.
                    }
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Blue)
                    .weight(1f)
                    .clickable {
                        boxColors[1] = !boxColors[1]
                        selectedColor = Color.Blue
                    }
            ) {
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .weight(1f)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow)
                    .weight(1f)
                    .clickable {
                        boxColors[2] = !boxColors[2]
                        selectedColor = Color.Yellow
                    }
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
                    .weight(1f)
                    .clickable {
                        boxColors[3] = !boxColors[3]
                        selectedColor = Color.Green
                    }
            ) {

            }
        }
    }
    return selectedColor;
}
