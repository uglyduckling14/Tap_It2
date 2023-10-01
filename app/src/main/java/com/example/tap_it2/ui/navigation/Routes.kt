package com.example.tap_it2.ui.navigation

data class Screen(val route:String)

object Routes {
    val Home = Screen("home")
    val Game = Screen("game")
}