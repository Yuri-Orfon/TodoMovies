package com.example.todomovies.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/76341?api_key=24dbe7a6b21397dea9854fa3b025b27f")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}