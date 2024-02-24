package com.example.watch.data.api.movieService

import javax.inject.Inject


class MovieService @Inject constructor() {
    private val retrofit = MovieClient.getClient()
    private val movieApi = retrofit.create(MovieApi::class.java)

    fun searchMovies(title: String, year: String?): List<MovieFromApi>? {
        return movieApi.movieList(title = title, year = year)
            .execute().body()?.Search?.toList()
    }
}