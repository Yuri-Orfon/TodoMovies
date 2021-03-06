package com.example.todomovies.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todomovies.R
import com.example.todomovies.data.helper.DateHelper
import com.example.todomovies.data.helper.ImageHelper
import com.example.todomovies.data.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieAdapter (private val list: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val title = itemView.nome_filme
        private val year = itemView.ano_filme
        private val imageUrl = itemView.image_movie
        private val imageHelp: ImageHelper = ImageHelper()
        private val dateHelp: DateHelper = DateHelper()

        fun bindView(holder: Movie){
            title.text = holder.title
            year.text = dateHelp.dateFormat(holder.release_date)
            imageHelp.insertImage(holder.backdrop_path, imageUrl)

        }
    }

}