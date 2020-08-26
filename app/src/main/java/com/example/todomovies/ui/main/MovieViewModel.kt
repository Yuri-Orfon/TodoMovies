package com.example.todomovies.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todomovies.data.model.MainMovie
import com.example.todomovies.data.model.Movie
import com.example.todomovies.data.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    val movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val mainMovieLiveData: MutableLiveData<MainMovie> = MutableLiveData()

    fun getMovies(){
        movieLiveData.value = createMovies()
    }

    fun getMoviesApi(){
        Api.serviceMovie.getMoviesDetail().enqueue(object: Callback<MainMovie> {
            override fun onResponse(call: Call<MainMovie>, response: Response<MainMovie>) {
                if(response.isSuccessful) {
                    response.body()?.let { movie ->
                        mainMovieLiveData.value = movie
                    }
                }
            }

            override fun onFailure(call: Call<MainMovie>, t: Throwable) {
                Log.i("APIMOVIE-ERROR-FAIL", "Erro no onResponse")
            }

        })
    }

    fun createMovies(): List<Movie>{
        return listOf(
            Movie("Teste","testando"),
            Movie("Teste","testando"),
            Movie("Teste","testando")
        )

    }
}
