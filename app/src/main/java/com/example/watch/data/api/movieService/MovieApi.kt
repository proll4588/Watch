package com.example.watch.data.api.movieService

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class MovieFromApi(
    val Title: String,
    val Year: String,
    val Poster: String,
    val imdbID: String
)

data class SearchMovieResponse(
    val Search: Array<MovieFromApi>
)

interface MovieApi {
    @GET("/")
    fun movieList(
        @Query("s") title: String,
        @Query("y") year: Int?,
        @Query("apikey") key: String? = "431f9cfd",
    ): Call<SearchMovieResponse>
}
