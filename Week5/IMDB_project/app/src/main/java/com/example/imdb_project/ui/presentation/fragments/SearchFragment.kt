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
        initViewBinding(inflater, container!!)
        configureRecyclerViews()
        return binding.root
    }

    private fun navigateToMovieDetails(movieModel: MovieModel) {
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(
            title = movieModel.title,
            originalTitle = movieModel.title,
            description = movieModel.overview,
            preview = movieModel.preview.toString(),
            thumbnail = movieModel.thumbnail.toString(),
            shortDescription = "short description",
            numberEpisodes = movieModel.numberOfEpisodes,
            stars = movieModel.rating
        )
        findNavController().navigate(action)
    }

    private fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup,
    ) {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
    }

    private fun configureRecyclerViews() {
        // get the recyclerview from the layout
        movieRecyclerView = binding.movieList

        // set the layout manager to linear
        movieRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        // instantiate the adapter and pass it to the recycler
        val movieListAdapter = MovieListAdapter(::navigateToMovieDetails)
        movieRecyclerView.adapter = movieListAdapter

        viewModel.getMoviesList()
        viewModel.movies.observe(requireActivity()) { moviesList ->
            movieListAdapter.submitList(moviesList)
        }
    }
}