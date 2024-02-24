package com.example.watch.ViewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watch.data.api.movieService.MovieFromApi
import com.example.watch.data.api.movieService.MovieService
import com.example.watch.libs.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObserveSearchMoviesViewModel @Inject constructor(
    private val movieService: MovieService,
) : ViewModel() {
    var searchMovies: MutableState<List<MovieFromApi>?> = mutableStateOf(listOf())
        private set

    fun searchMovies(title: String, year: String?) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val found = movieService.searchMovies(title, year)
            searchMovies.value = found
            Log.d("found", found.toString())
        }
    }
}