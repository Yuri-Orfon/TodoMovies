package com.example.todomovies.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todomovies.data.model.Movie

class MovieViewModel : ViewModel() {
    val movieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getMovies(){
        movieLiveData.value = createMovies()
    }

    fun createMovies(): List<Movie>{
        return listOf(
            Movie("Teste",2020,"testando"),
            Movie("Teste",2020,"testando"),
            Movie("Teste",2020,"testando")
        )

    }
}
