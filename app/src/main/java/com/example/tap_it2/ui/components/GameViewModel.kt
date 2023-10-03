package com.example.tap_it2.ui.components

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.tap_it.generateRandomColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class GameUiState(
    val level: Int =1,
    val current: Int = 1,
    val selectedColor: Color = Color.White,
    val levels: Map<Int, Color> = mapOf(
            1 to generateRandomColor(),
            2 to generateRandomColor()
            ),
    val restart: Boolean = false
)
class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())

    fun onClick(){
        if (_uiState.value.current == _uiState.value.level && Check(
                _uiState.value.selectedColor,
                _uiState.value.levels,
                _uiState.value.current
            )
        ) {
            _uiState.update { currentState ->
                currentState.copy(
                    current = 1,
                    level = currentState.level+1,
                    selectedColor = currentState.selectedColor,
                    levels = currentState.levels,
                    restart = false
                )
            }
        } else if (Check(_uiState.value.selectedColor, _uiState.value.levels, _uiState.value.current)) {
            val size = _uiState.value.levels.size + 1
            val levels = _uiState.value.levels.toMutableMap()
            levels[size] = generateRandomColor()
            _uiState.update { currentState ->
                currentState.copy(
                    current = currentState.current+1,
                    levels = levels,
                    selectedColor = currentState.selectedColor,
                    level = currentState.level,
                    restart = false
                )
            }
        }
    }

    fun Check(selected: Color, levels: Map<Int, Color>, current: Int): Boolean{
        return selected == levels[current]
    }

    fun clearData(){
        _uiState.update { currentState ->
            currentState.copy(
                current = 1,
                levels = mapOf(
                    1 to generateRandomColor(),
                    2 to generateRandomColor()
                ),
                selectedColor = Color.White,
                level = 1,
                restart = false
            )
        }
    }
}