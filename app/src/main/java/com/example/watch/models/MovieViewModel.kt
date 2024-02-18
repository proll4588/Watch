package com.example.watch.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.data.entity.Movie
import com.example.watch.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MovieViewModel(
    private val movieRepository: MovieRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    val movies = movieRepository.allMovies

    fun handleEvent(action: MovieViewModelEvents, movie: Movie) {
        when (action) {
            MovieViewModelEvents.ADD -> addMovie(movie)
            MovieViewModelEvents.REMOVE -> removeMovie(movie)
        }
    }

    private fun addMovie(movie: Movie) {
        viewModelScope.launch(ioDispatcher) {
            movieRepository.insert(movie)
        }
    }

    private fun removeMovie(movie: Movie) {
        viewModelScope.launch(ioDispatcher) {
            movieRepository.delete(movie)
        }
    }

}

enum class MovieViewModelEvents {
    ADD,
    REMOVE
}