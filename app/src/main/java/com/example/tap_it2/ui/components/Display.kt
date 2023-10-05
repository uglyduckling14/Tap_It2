package com.example.tap_it

import android.graphics.Color.BLUE
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.graphics.Color.YELLOW
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tap_it2.ui.viewmodels.GameUiState
import com.example.tap_it2.ui.viewmodels.GameViewModel



//Page of game
@Composable
fun Display(navController:NavController){
    //level of game
    val viewModel: GameViewModel = viewModel()
    val state = viewModel._uiState
    LaunchedEffect(true){
        viewModel.reset()
        viewModel.load()
    }
    
    var colors1 = listOf(RED, YELLOW)
    var colors2 = listOf(BLUE, GREEN)

    //what color in the list of pattern the user is on
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
            Text(text = "Level ${state.level}")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            CreatePrompt(state.levels, state.level)
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
                                .background(Color(color))
                                .weight(1f)
                                .clickable {
                                    viewModel.setInt("selectedColor", color)
                                    viewModel.setInt("level", state.level)
                                    viewModel.setInt("current", state.current)
                                    viewModel.setBoolean("restart", state.restart)
                                    viewModel.onClick()
                                    println("level ${state.highScore}")
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
                                .background(Color(color))
                                .weight(1f)
                                .clickable {
                                    viewModel.setInt("selectedColor", color)
                                    viewModel.setInt("level", state.level)
                                    viewModel.setInt("current", state.current)
                                    viewModel.setBoolean("restart", state.restart)
                                    viewModel.onClick()
                                    println("level ${state.level}")
                                }
                        ) {}
                    }
                }
            }
        }
        if(state.restart){
            Text(text="You Lost! You reached level: ${state.level}")
            Button(onClick = {
                viewModel.reset()
                navController.navigate("home")
            },
                colors = ButtonDefaults.buttonColors( containerColor = Color.Red, contentColor = Color.White)
            ) {
                Text(text ="Back to Main Screen")
            }

        }
    }
}

@Composable
fun CreatePrompt(levels: Map<Int,Int>, level: Int){
    levels[level]?.let { Prompt(it) };
}

//What color to pick
@Composable
fun Prompt(color: Int){
    val intToColor = Color(color)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(intToColor)
    ){
    }
}


@Composable
fun rememberGameUiState(): GameUiState{
    return remember {
        GameUiState()
    }
}