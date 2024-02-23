package com.example.watch.data.repository

import com.example.watch.data.database.MovieDao
import com.example.watch.data.database.entity.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieDao: MovieDao) {
    val allMovies: Flow<List<Movie>> = movieDao.getAllMovies()

    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

    suspend fun delete(movie: Movie) {
        movieDao.delete(movie)
    }
}