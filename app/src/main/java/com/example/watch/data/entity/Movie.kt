package com.example.watch.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey
    val imdbID: String,
    val title: String,
    val year: Int,
    val posterUrl: String
)
