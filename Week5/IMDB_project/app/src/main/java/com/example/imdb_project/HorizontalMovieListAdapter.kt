package com.example.imdb_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class HorizontalMovieListAdapter :
    ListAdapter<Movie, HorizontalMovieViewHolder>(HorizontalMovieDiffCallBack()) {
    private class HorizontalMovieDiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
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
    }
}