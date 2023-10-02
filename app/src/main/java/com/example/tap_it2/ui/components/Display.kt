package com.example.tap_it

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tap_it2.ui.components.OnClick


//Page of game
@Composable
fun Display(levelsList: MutableMap<Int, Color>){
    //level of game
    var levels = levelsList
    if(levels.size<2){
        levels[1] = generateRandomColor()
        levels[2] = generateRandomColor()
    }
    var colors1 = listOf(Color.Red, Color.Yellow)
    var colors2 = listOf(Color.Blue, Color.Green)
    var level by remember {
        mutableStateOf(1)
    }
    //what color in the list of pattern the user is on
    var current by remember {
        mutableStateOf(1)
    }
    var selectedColor by remember {
        mutableStateOf(Color.White)
    }
    var restart by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.25f),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Level $level")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            CreatePrompt(levels, level)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White)
            ){
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f)
                ) {
                for (color in colors1) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .weight(1f)
                                .clickable {
                                    selectedColor = color
                                    val onClick = OnClick(restart, current, selectedColor, levels, level)
                                    onClick.onClick()
                                    levels= onClick.levels
                                    current=onClick.current
                                    level=onClick.level
                                    restart = onClick.restart
                                    println(level)
                                }
                            ){}
                        }
                    }
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f)
                ) {
                for (color in colors2) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .weight(1f)
                                .clickable {
                                    selectedColor = color
                                    val onClick = OnClick(restart, current, selectedColor, levels, level)
                                    onClick.onClick()
                                    levels= onClick.levels
                                    current=onClick.current
                                    level=onClick.level
                                    restart = onClick.restart
                                    println(level)
                                }
                        ) {}
                    }
                }
            }
        }
        if(restart){
            Text(text="You Lost! You reached level: $level")
            Button(onClick = {
                current = 1
                level = 1
                selectedColor = Color.White
                levels.clear()
                restart = false
            }) {
                Text(text ="Restart?")
            }

        }
    }
}

@Composable
fun CreatePrompt(levels: Map<Int,Color>, level: Int){
    levels[level]?.let { Prompt(it) };
}

//Compares the colors the user has selected so far to the level colors
fun Check(selected: Color, levels: Map<Int,Color>, current: Int): Boolean {
    return selected == levels[current]
}
//What color to pick
@Composable
fun Prompt(color: Color){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
    ){

    }
}