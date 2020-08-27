package com.example.todomovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todomovies.R
import com.example.todomovies.data.helper.ImageHelper
import com.example.todomovies.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val imageHelp = ImageHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()
    }

    fun initializer(){
        val viewModel: MovieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        initRecyclerView(viewModel)
        initMainMovie(viewModel)
    }

    fun initRecyclerView(viewModel: MovieViewModel) {
        viewModel.movieLiveData.observe(this, Observer {
            it?.let {movie ->
                with(recyclerView){
                    layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = MovieAdapter(movie)
                }
            }
        })
        viewModel.getMoviesList()
    }

    fun initMainMovie(viewModel: MovieViewModel) {

        viewModel.mainMovieLiveData.observe(this, Observer {mainMovie ->
            mainMovie?.let{
                setLayoutMainMovie(mainMovie.title, mainMovie.popularity, mainMovie.vote_count, mainMovie.backdrop_path)
            }
        })
        viewModel.getMoviesApi()
    }

    private fun setLayoutMainMovie(title: String, popularity: String, vote_count: String, backdrop_path: String) {
        video_title.setText(title)
        number_views.setText(popularity)
        number_likes.setText(vote_count)

        val url = imageHelp.complementImageRF(backdrop_path)
        imageHelp.insertImage(url, imageView)
    }
}
