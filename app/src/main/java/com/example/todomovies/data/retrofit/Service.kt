package com.example.todomovies.data.retrofit

import com.example.todomovies.data.model.MainMovie
import com.example.todomovies.data.model.Movie
import com.example.todomovies.data.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("{id}?api_key=24dbe7a6b21397dea9854fa3b025b27f")
    fun getMoviesDetail(@Path("id")id: Int) : Call<MainMovie>

    @GET("{id}/similar?api_key=24dbe7a6b21397dea9854fa3b025b27f")
    fun getMoviesList(@Path("id")id: Int) : Call<RecyclerList>
}