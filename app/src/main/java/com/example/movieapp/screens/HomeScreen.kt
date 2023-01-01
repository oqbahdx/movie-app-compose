package com.example.movieapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigations.MovieScreen

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(backgroundColor = Color.Black, elevation = 5.dp) {
                Text(text = "Movies App", style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
        }) {
        MainContent(navController)
    }
}
@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf(
        "Movie 1",
        "Movie 2",
        "Movie 3",
        "Movie 4",
        "Movie 5",
        "Movie 6",
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {

            items(items = moviesList) {
                MovieRow(movie = it){
                    navController.navigate(MovieScreen.DetailsScreen.name)
                }
            }
        }
    }


}
