package com.example.tap_it2.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color.WHITE
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.tap_it.generateRandomColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class GameUiState {
    var level by mutableIntStateOf(1)
    var current by mutableIntStateOf(1)
    var selectedColor by mutableIntStateOf(WHITE)
    var levels = mutableMapOf(
        1 to generateRandomColor(),
        2 to generateRandomColor()
    )
    var restart by mutableStateOf(false)
    var highScore by mutableIntStateOf(0)
}
class GameViewModel(game: Application): AndroidViewModel(game) {
    val _uiState = GameUiState()
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
        _uiState.restart = sharedPreferences.getBoolean("restart", false)
        _uiState.selectedColor = sharedPreferences.getInt("selectedColor", generateRandomColor())
        _uiState.current = sharedPreferences.getInt("current", 1)
        _uiState.level = sharedPreferences.getInt("level", 1)
        _uiState.levels = mutableMapOf(
            1 to generateRandomColor(),
            2 to generateRandomColor()
        )
    }

    fun setInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
        when (key) {
            "highScore" -> _uiState.highScore = value
            "level" -> _uiState.level = value
            "current" -> _uiState.current = value
            "selectedColor" -> _uiState.selectedColor = value

        }
    }
    fun setBoolean(key: String, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
        when (key) {
            "restart" -> _uiState.restart = value
        }
    }

    fun reset(){
        sharedPreferences.edit().putInt("level", 1).apply()
        sharedPreferences.edit().putInt("current",1).apply()
        sharedPreferences.edit().putBoolean("restart", false).apply()
    }

    fun onClick() {
        if (!Check(_uiState.selectedColor, _uiState.levels, _uiState.current)) {
            setBoolean("restart", true)
            println("failed!")
        } else if (_uiState.current == _uiState.level && Check(
                _uiState.selectedColor,
                _uiState.levels,
                _uiState.current,
            )
        ) {
            setBoolean("restart", false)
            setInt("current", 1)
            setInt("level", _uiState.level+1)
            if(_uiState.highScore<_uiState.level){
                println("highscore ${sharedPreferences.getInt("highScore",0)}")
                setInt("highScore", _uiState.highScore+1)
            }

        } else if (Check(_uiState.selectedColor, _uiState.levels, _uiState.current)) {
            val size = _uiState.levels.size + 1
            val levels = _uiState.levels.toMutableMap()
            levels[size] = generateRandomColor()
            setBoolean("restart", false)
            setInt("current", _uiState.current+1)
            _uiState.levels[size] = generateRandomColor()
        }
    }

    fun Check(selected: Int, levels: Map<Int, Int>, current: Int): Boolean {
        return selected == levels[current]
    }
}

