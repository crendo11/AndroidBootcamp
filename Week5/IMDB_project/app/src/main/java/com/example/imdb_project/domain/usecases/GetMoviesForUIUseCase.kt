package com.example.imdb_project.domain.usecases

import com.example.imdb_project.domain.models.MovieModel

interface GetMoviesForUIUseCase {
    suspend fun getMovies(): List<MovieModel>
}
