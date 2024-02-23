package com.example.watch.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.watch.data.database.entity.Movie

@Composable
fun MovieCard(movie: Movie, onClick: () -> Unit, content: @Composable (() -> Unit) = {}) {
    MovieCard(
        onClick = onClick,
        year = movie.Year,
        title = movie.Title,
        imgUrl = movie.Poster,
        content = content

    )
}

@Composable
private fun MovieCard(
    imgUrl: String,
    title: String,
    year: String,
    content: @Composable (() -> Unit) = {},
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(all = 0.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row {
            AsyncImage(
                model = imgUrl,
                contentDescription = "Movie $title",
                modifier = Modifier
                    .width(90.dp)
                    .fillMaxHeight(),
                alignment = Alignment.TopStart
            )
            Column {
                Text(text = title, style = MaterialTheme.typography.headlineMedium)
                Text(text = year.toString())
            }
            content()
        }
    }
}