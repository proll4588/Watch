package com.example.watch.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey
    val imdbID: String,
    val Title: String,
    val Year: String,
    val Poster: String
)
