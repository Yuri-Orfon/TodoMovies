package com.example.todomovies.data.helper

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageHelper {
    private val URL_IMAGE = "http://image.tmdb.org/t/p/w500"

    fun complementImageRF(backdrop_path: String) : String = URL_IMAGE + backdrop_path

    fun insertImage(url: String, imageView: ImageView) {
        Picasso.get().load(url).into(imageView)
    }
}