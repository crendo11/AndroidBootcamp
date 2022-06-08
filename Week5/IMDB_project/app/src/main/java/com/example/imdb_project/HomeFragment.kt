package com.example.imdb_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var horizontalMovieRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        // get the recyclerview from the layout
        horizontalMovieRecyclerView = view.findViewById(R.id.homeRecyclerView)

        // set the layout manager to linear
        horizontalMovieRecyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        // instantiate the adapter and pass it to the recycler
        val movieListAdapter = HorizontalMovieListAdapter()
        horizontalMovieRecyclerView.adapter = movieListAdapter

        // get list of movies and pass them to adapter
        val moviesList = Movies(view.context).movies
        movieListAdapter.submitList(moviesList)

        return view
    }
}