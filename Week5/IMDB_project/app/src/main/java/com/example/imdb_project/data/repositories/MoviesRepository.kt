package com.example.imdb_project.data.repositories

import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.domain.usecases.GetMoviesForUIUseCase

interface MoviesRepository: GetMoviesForUIUseCase {
    override suspend fun getMovies(): List<MovieModel>
    override suspend fun getRatedMovies(): List<MovieModel>
}