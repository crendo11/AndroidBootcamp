package com.example.imdb_project.ui.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.R

class HorizontalMovieViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    private val title = viewItem.findViewById<TextView>(R.id.horizontalMovieTitle)
    private val thumbnail = viewItem.findViewById<ImageView>(R.id.horizontalMovieThumbnail)
    private val movieRating = viewItem.findViewById<TextView>(R.id.movieRating)

    fun bind(movieModel: MovieModel){
        title.text = movieModel.title
        movieRating.text = movieModel.rating.toString()
        thumbnail.setImageResource(movieModel.thumbnail)
    }
}