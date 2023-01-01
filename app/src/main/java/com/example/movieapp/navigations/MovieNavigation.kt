package com.example.movieapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.DetailsScreen
import com.example.movieapp.screens.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreen.HomeScreen.name
    ) {
        composable(MovieScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
         composable(MovieScreen.DetailsScreen.name){
             DetailsScreen(navController = navController)
         }
    }
}