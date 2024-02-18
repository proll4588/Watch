package com.example.watch.data.repository

import com.example.watch.data.database.MovieDao
import com.example.watch.data.entity.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {
    val allMovies: Flow<List<Movie>> = movieDao.getAllMovies()

    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    suspend fun delete(movie: Movie) {
        movieDao.delete(movie)
    }
}