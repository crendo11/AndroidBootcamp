package com.example.imdb_project.data.repositories

import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.domain.usecases.GetMoviesForUIUseCase

interface MoviesRepository: GetMoviesForUIUseCase {
    override fun getMovies(): List<MovieModel>
}