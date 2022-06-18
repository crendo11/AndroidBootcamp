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
import com.example.imdb_project.R
import com.example.imdb_project.ui.presentation.customviews.SectionTitleView
import com.example.imdb_project.ui.viewmodel.MoviesForUIViewModel

class HomeFragment : Fragment() {

    private lateinit var horizontalMovieRecyclerView: RecyclerView
    private lateinit var sectionTitleView: SectionTitleView

    // Bring viewModel
    private val viewModel by viewModels<MoviesForUIViewModel>()

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

        val movieListAdapter = HorizontalMovieListAdapter(::navigateToMovieDetails)
        horizontalMovieRecyclerView.adapter = movieListAdapter

        viewModel.setView()
        // listen to LiveData of movies
        viewModel.movies.observe(requireActivity()) { moviesList ->
            movieListAdapter.submitList(moviesList)
        }

        // set section title for best selections
        sectionTitleView = view.findViewById(R.id.bestSelectionsTitle)
        sectionTitleView.setTitle(getString(R.string.best_selections))

        return view
    }

    private fun navigateToMovieDetails(movieModel: MovieModel) {
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(
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