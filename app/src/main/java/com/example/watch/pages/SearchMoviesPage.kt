package com.example.watch.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SearchMoviesPage(
    onNavigateBack: () -> Unit,
    onNavigateToObserveSearchMoviesPage: () -> Unit
) {
    Column {
        Text(text = "SearchMoviesPage")
        Button(onClick = onNavigateBack) {
            Text(text = "Navigate back")
        }
        Button(onClick = onNavigateToObserveSearchMoviesPage) {
            Text(text = "Navigate to ObserveSearchMoviesPage")
        }
    }
}