package com.example.todomovies.data.retrofit

import com.example.todomovies.data.model.MainMovie
import com.example.todomovies.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("550?api_key=24dbe7a6b21397dea9854fa3b025b27f")
    fun getMoviesDetail() : Call<MainMovie>
}