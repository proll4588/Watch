package com.example.watch.ViewModels

import androidx.lifecycle.ViewModel
import com.example.watch.data.database.entity.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SelectingMovieViewModel @Inject constructor() : ViewModel() {
    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie.asStateFlow()

    fun selectMovie(movie: Movie) {
        _selectedMovie.value = movie
    }

    fun clear() {
        _selectedMovie.value = null
    }
}