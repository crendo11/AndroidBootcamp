package com.example.imdb_project.ui.presentation.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.imdb_project.R
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.ui.presentation.HorizontalMovieViewHolder

class HorizontalMovieListAdapter(private val clickHandler: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, HorizontalMovieViewHolder>(HorizontalMovieDiffCallBack()) {
    private class HorizontalMovieDiffCallBack : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalMovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_movie_item, parent, false)
        return HorizontalMovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HorizontalMovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener{
            clickHandler(movie)
        }
    }
}