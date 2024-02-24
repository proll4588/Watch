package com.example.watch.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.data.database.entity.Movie
import com.example.watch.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyMoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    val movies = movieRepository.allMovies

    fun removeMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.delete(movie)
        }
    }
}

