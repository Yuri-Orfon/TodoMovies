package com.example.todomovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.todomovies.R
import com.example.todomovies.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializer()
    }

    fun initializer(){
        val URL_IMAGE = "http://image.tmdb.org/t/p/w500"

        val viewModel: MovieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        initRecyclerView(viewModel)
        initMainMovie(viewModel, URL_IMAGE)
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
        viewModel.getMovies()
    }

    fun initMainMovie(viewModel: MovieViewModel, URL_IMAGE: String) {

        viewModel.mainMovieLiveData.observe(this, Observer {
            it?.let{
                val title = it.title
                val popularity = it.popularity
                val vote_count = it.vote_count
                val backdrop_path = it.backdrop_path
                video_title.setText(title)
                number_views.setText(popularity)
                number_likes.setText(vote_count)

                val url = URL_IMAGE + backdrop_path
                Glide.with(this)
                    .load(url)
                    .into(imageView)

            }
        })
        viewModel.getMoviesApi()
    }
}
