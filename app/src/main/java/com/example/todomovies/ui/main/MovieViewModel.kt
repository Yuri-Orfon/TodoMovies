package com.example.todomovies.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todomovies.data.model.MainMovie
import com.example.todomovies.data.model.Movie
import com.example.todomovies.data.model.RecyclerList
import com.example.todomovies.data.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    val movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val mainMovieLiveData: MutableLiveData<MainMovie> = MutableLiveData()
    private val idUrl = 550

    fun getMoviesApi(){
        Api.serviceMovie.getMoviesDetail(idUrl).enqueue(object: Callback<MainMovie> {
            override fun onResponse(call: Call<MainMovie>, response: Response<MainMovie>) {
                if(response.isSuccessful) {
                    response.body()?.let { movie ->
                        mainMovieLiveData.value = movie
                    }
                }
            }

            override fun onFailure(call: Call<MainMovie>, t: Throwable) {
                Log.i("APIMOVIE-ERROR-FAIL", "Erro no onResponse - getMoviesApi")
            }
        })
    }

    fun getMoviesList(){
        val URL_IMAGE = "http://image.tmdb.org/t/p/w500"
        Api.serviceRecyclerList.getMoviesList(idUrl).enqueue(object: Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    response.body()?.let { movieList ->
                        val list: MutableList<Movie> = mutableListOf()
                        for (result in movieList.results) {
                            val sup = result.backdrop_path
                            result.backdrop_path = URL_IMAGE + sup
                            val listMovie = result.getMovieListModel()
                            Log.i("APIMOVIE", "${listMovie.title} / ${listMovie.release_date} / ${listMovie.backdrop_path}")
                            list.add(listMovie)
                        }
                        movieLiveData.value = list
                    }
                }
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Log.i("APIMOVIE-ERROR-FAIL", "Erro no onResponse - getMoviesList")
            }
        })
    }
}
