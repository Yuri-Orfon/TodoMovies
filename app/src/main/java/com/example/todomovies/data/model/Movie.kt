package com.example.todomovies.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie (
    @Json(name = "original_title")
    val title: String,
    @Json(name = "release_date")
    val release_date: String,

    ) {
    fun getMovieModel() = Movie(
        title = this.title,
        release_date = this.release_date
    )
}