package com.example.imdb_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class MovieListAdapter(private val clickHandler: (Movie) -> Unit) :
    ListAdapter<Movie, MovieViewHolder>(MovieDiffCallBack()) {
    private class MovieDiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            clickHandler(movie)
        }
    }
}