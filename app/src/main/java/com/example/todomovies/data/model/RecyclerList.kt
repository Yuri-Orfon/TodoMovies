package com.example.todomovies.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecyclerList (
    @Json(name = "results")
    val results: List<Movie>
    )