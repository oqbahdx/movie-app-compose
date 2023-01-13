package com.example.movieapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.models.Movie
import com.example.movieapp.models.getMovies
import com.example.movieapp.widgets.MovieRow


@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
   val newMoviesList = getMovies().filter { movie ->
       movie.id == movieId
   }
    Scaffold(
        topBar = {
        TopAppBar(backgroundColor = Color.Black, elevation = 5.dp) {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    },
                )
                Spacer(modifier = Modifier.width(150.dp))
            }
            Text(
                text = newMoviesList[0].title,
                style = TextStyle(fontSize = 20.sp, color = Color.White)
            )
        }
    }) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
             MovieRow(movie = newMoviesList.first())
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
           Text(text = "Movie Images")
            HorizontalScrollableImagesView(newMoviesList)


        }
    }

}

@Composable
private fun HorizontalScrollableImagesView(newMoviesList: List<Movie>) {
    LazyRow {
        items(newMoviesList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp), elevation = 5.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "movie images"
                )
            }

        }
    }
}



