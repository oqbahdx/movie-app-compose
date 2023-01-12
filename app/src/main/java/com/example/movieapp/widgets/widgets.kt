package com.example.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.movieapp.models.Movie

@Composable
fun MovieRow(movie: Movie, onTap: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                onTap(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 5.dp

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp,

                ) {
                Image(

                    rememberAsyncImagePainter(
                        movie.images[0],
                        contentScale = ContentScale.FillHeight,
                        transform = AsyncImagePainter.DefaultTransform
                    ), contentDescription = "image poster",
                    modifier = Modifier.fillMaxSize(),
                )

            }
            Column {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director : ${movie.director}", style = MaterialTheme.typography.body1)
                Text(text = "Released : ${movie.year}", style = MaterialTheme.typography.body1)
            }

        }


    }
}
