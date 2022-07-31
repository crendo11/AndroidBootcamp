package com.example.imdb_project.ui.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
        movieYear.text = movieModel.releaseDate.toString()
        thumbnail.load(movieModel.thumbnail){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_baseline_error_24)
        }
    }
}