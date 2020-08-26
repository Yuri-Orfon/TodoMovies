package com.example.todomovies.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainMovie (
    @Json(name = "original_title")
    val title: String,
    @Json(name = "popularity")
    val popularity: String,
    @Json(name = "vote_count")
    val vote_count: String,
    @Json(name = "backdrop_path")
    val backdrop_path: String)