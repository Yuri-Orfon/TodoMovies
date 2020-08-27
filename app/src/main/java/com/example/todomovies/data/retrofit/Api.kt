package com.example.todomovies.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val serviceMovie: Service = initRetrofit()
        .create(Service::class.java)

    val serviceRecyclerList: Service = initRetrofit()
        .create(Service::class.java)
}