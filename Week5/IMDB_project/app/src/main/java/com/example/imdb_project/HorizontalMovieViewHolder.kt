package com.example.imdb_project

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorizontalMovieViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    private val title = viewItem.findViewById<TextView>(R.id.horizontalMovieTitle)
    private val thumbnail = viewItem.findViewById<ImageView>(R.id.horizontalMovieThumbnail)
    private val movieRating = viewItem.findViewById<TextView>(R.id.movieRating)

    fun bind(movie: Movie){
        title.text = movie.title
        movieRating.text = movie.rating.toString()
        thumbnail.setImageResource(movie.thumbnail)
    }
}