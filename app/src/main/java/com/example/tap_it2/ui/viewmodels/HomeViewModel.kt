package com.example.tap_it2.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.tap_it.generateRandomColor

class HomeUiState{
    var highScore by mutableIntStateOf(0)
}
class HomeViewModel (game: Application):AndroidViewModel(game){
    val _uiState = HomeUiState()
    private var sharedPreferences: SharedPreferences
    init {
        sharedPreferences = game.getSharedPreferences("highScore", Context.MODE_PRIVATE)
        sharedPreferences = game.getSharedPreferences("restart", Context.MODE_PRIVATE)
        sharedPreferences = game.getSharedPreferences("selectedColor", Context.MODE_PRIVATE)
        sharedPreferences = game.getSharedPreferences("current", Context.MODE_PRIVATE)
        sharedPreferences = game.getSharedPreferences("level", Context.MODE_PRIVATE)
    }
    fun load() {
        _uiState.highScore = sharedPreferences.getInt("highScore", 0)
    }
}
