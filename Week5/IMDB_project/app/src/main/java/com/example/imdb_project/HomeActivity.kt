package com.example.imdb_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // get the recyclerview from the layout
        val movieRecyclerView: RecyclerView = findViewById(R.id.movieList)

        // set the layout manager to linear
        movieRecyclerView.layoutManager = LinearLayoutManager(this)

        // instantiate the adapter and pass it to the recycler
        val movieListAdapter = MovieListAdapter()
        movieRecyclerView.adapter = movieListAdapter

        // get list of movies and pass them to adapter
        val moviesList = Movies().movies
        movieListAdapter.submitList(moviesList)
    }
}