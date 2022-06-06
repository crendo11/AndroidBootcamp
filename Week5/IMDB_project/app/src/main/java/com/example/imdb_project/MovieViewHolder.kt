package com.example.imdb_project

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    private val title = viewItem.findViewById<TextView>(R.id.movieTitle)
    private val thumbnail = viewItem.findViewById<ImageView>(R.id.movieThumbnail)
    private val actors = viewItem.findViewById<TextView>(R.id.movieActors)
    private val movieYear = viewItem.findViewById<TextView>(R.id.movieYear)

    fun bind(movie: Movie){
        title.text = movie.title
        actors.text = movie.actors.joinToString()
        movieYear.text = movie.year.toString()
        thumbnail.setImageResource(movie.thumbnail)
    }
}