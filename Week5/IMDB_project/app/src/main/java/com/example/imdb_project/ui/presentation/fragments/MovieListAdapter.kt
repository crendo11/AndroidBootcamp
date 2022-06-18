package com.example.imdb_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.ui.presentation.MovieViewHolder

class MovieListAdapter(private val clickHandler: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieViewHolder>(MovieDiffCallBack()) {
    private class MovieDiffCallBack : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
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