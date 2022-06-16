package com.example.imdb_project.ui.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.MovieListAdapter
import com.example.imdb_project.Movies
import com.example.imdb_project.R
import com.example.imdb_project.databinding.MovieDetailsFragmentBinding
import com.example.imdb_project.databinding.SearchFragmentBinding
import com.example.imdb_project.ui.viewmodel.MoviesForUIViewModel

class SearchFragment : Fragment() {

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MoviesForUIViewModel>()
    private lateinit var movieRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // get the recyclerview from the layout
        movieRecyclerView = binding.movieList

        // set the layout manager to linear
        movieRecyclerView.layoutManager = LinearLayoutManager(view.context)

        // instantiate the adapter and pass it to the recycler
        val movieListAdapter = MovieListAdapter(::navigateToMovieDetails)
        movieRecyclerView.adapter = movieListAdapter

        viewModel.setView()
        viewModel.movies.observe(requireActivity()){ moviesList ->
            movieListAdapter.submitList(moviesList)
        }

        return view
    }

    private fun navigateToMovieDetails(movieModel: MovieModel) {
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(
            title = movieModel.title,
            originalTitle = movieModel.title,
            description = movieModel.description,
            preview = movieModel.preview,
            thumbnail = movieModel.thumbnail,
            shortDescription = "short description",
            numberEpisodes = movieModel.numberOfEpisodes,
            stars = movieModel.rating
        )
        findNavController().navigate(action)
    }
}