package com.example.watch.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.data.database.entity.Movie
import com.example.watch.data.repository.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    private fun addMovie(movie: Movie) {
        viewModelScope.launch {
            movieRepository.insert(movie)
        }
    }
}