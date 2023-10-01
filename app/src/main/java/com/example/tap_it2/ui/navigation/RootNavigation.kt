package com.example.tap_it2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tap_it2.ui.screens.GameScreen
import com.example.tap_it2.ui.screens.HomeScreen

@Composable
fun RootNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable(Routes.Home.route){HomeScreen(navController = navController)}
        composable(Routes.Game.route){ GameScreen(navController = navController)}
    }
}