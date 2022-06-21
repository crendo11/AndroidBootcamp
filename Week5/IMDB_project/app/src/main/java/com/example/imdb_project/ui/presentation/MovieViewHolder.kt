package com.example.imdb_project.ui.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.R

class MovieViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    private val title = viewItem.findViewById<TextView>(R.id.movieTitle)
    private val thumbnail = viewItem.findViewById<ImageView>(R.id.movieThumbnail)
    private val actors = viewItem.findViewById<TextView>(R.id.movieActors)
    private val movieYear = viewItem.findViewById<TextView>(R.id.movieYear)

    fun bind(movieModel: MovieModel){
        title.text = movieModel.title
        actors.text = movieModel.actors.joinToString()
        movieYear.text = movieModel.year.toString()
        thumbnail.setImageResource(movieModel.thumbnail)
    }
}