package com.example.imdb_project.menu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.example.imdb_project.R
import com.example.imdb_project.databinding.MovieDetailsFragmentBinding

class MovieDetailsFragment : Fragment() {

    private val args: MovieDetailsFragmentArgs by navArgs()
    private var _binding: MovieDetailsFragmentBinding ? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // setup toolbar with nav controller
        val navController = findNavController()
        val toolbar = binding.detailsToolbar
        toolbar.setupWithNavController(navController)

        // get views and fill with data
        binding.detailsToolbar.title = args.title
        binding.movieOriginalTitle.text = args.originalTitle
        binding.movieDetailsTitle.setTitle(args.title)
        binding.shortDescription.text = args.shortDescription
        binding.moviePreview.setImageResource(args.preview)
        binding.movieDetailsThumbnail.setImageResource(args.thumbnail)
        binding.starRating.text = args.stars.toString()
        binding.numberEpisodes.text = getStringNumberOfEpisodes(args.numberEpisodes)
        binding.movieDescription.text = args.description

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getStringNumberOfEpisodes(numberEpisodes: Int): String{
        return if (numberEpisodes == 1) {
            "$numberEpisodes ${getString(R.string.episode)}"
        } else {
            "$numberEpisodes ${getString(R.string.episodes)}"
        }
    }
}