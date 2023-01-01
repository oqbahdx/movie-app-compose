package com.example.movieapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DetailsScreen(navController: NavController) {

    Text(text = "Details Screen", style = TextStyle(fontSize = 25.sp))
}