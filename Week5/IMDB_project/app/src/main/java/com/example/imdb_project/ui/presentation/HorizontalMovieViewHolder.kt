package com.example.imdb_project.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_project.Movie
import com.example.imdb_project.R

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