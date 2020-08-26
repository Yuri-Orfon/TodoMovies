package com.example.todomovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todomovies.R
import com.example.todomovies.data.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()
    }

    fun initializer(){
        val viewModel: MovieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.movieLiveData.observe(this, Observer {
            it?.let {movie ->
                with(recyclerView){
                    layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = MovieAdapter(movie)
                }
            }
        })
        viewModel.getMovies()
        viewModel.getMoviesApi()
    }
}
