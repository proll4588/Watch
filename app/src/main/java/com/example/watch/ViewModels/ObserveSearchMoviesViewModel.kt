package com.example.watch.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.data.api.movieService.MovieFromApi
import com.example.watch.data.api.movieService.MovieService
import com.example.watch.libs.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObserveSearchMoviesViewModel @Inject constructor(
    private val movieService: MovieService,
) : ViewModel() {
    var searchMovies: MutableState<List<MovieFromApi>?> = mutableStateOf(listOf())
        private set

    fun searchMovies(title: String, year: Int?) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val found = movieService.searchMovies(title, year)
            searchMovies.value = found
        }
    }
}