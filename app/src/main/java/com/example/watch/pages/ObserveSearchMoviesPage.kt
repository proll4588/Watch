package com.example.watch.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ObserveSearchMoviesPage(
    onNavigateBack: () -> Unit
) {
    Column {
        Text(text = "ObserveSearchMoviesPage")
        Button(onClick = onNavigateBack) {
            Text(text = "Navigate back")
        }
    }
}