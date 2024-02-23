package com.example.watch.data.api.movieService

import com.example.watch.data.api.libs.RequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {
    private const val BASE_URL = "http://www.omdbapi.com/"

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(RequestInterceptor)
        .build()


    fun getClient(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}