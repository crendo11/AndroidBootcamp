package com.example.imdb_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment: Fragment() {

    private lateinit var movieRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.search_fragment, container, false)

        // get the recyclerview from the layout
        movieRecyclerView = view.findViewById(R.id.movieList)

        // set the layout manager to linear
        movieRecyclerView.layoutManager = LinearLayoutManager(view.context)

        // instantiate the adapter and pass it to the recycler
        val movieListAdapter = MovieListAdapter()
        movieRecyclerView.adapter = movieListAdapter

        // get list of movies and pass them to adapter
        val moviesList = Movies(view.context).movies
        movieListAdapter.submitList(moviesList)

        return view
    }
}