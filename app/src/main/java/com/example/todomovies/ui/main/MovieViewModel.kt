package com.example.todomovies.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todomovies.data.model.Movie
import com.example.todomovies.data.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    val movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies(){
        movieLiveData.value = createMovies()
    }

    fun getMoviesApi(){
        Api.serviceMovie.getMoviesDetail().enqueue(object: Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if(response.isSuccessful) {
                    response.body()?.let { moviesList ->
                        Log.i("APIMOVIE-SUCESS", "title = ${moviesList.title} / year = ${moviesList.release_date}")
                    }
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.i("APIMOVIE-ERROR-FAIL", "Erro no onResponse",t)
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
