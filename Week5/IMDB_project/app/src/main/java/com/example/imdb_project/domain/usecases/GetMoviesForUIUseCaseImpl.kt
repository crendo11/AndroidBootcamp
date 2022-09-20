package com.example.imdb_project.domain.usecases

import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.data.repositories.MoviesRepository

class GetMoviesForUIUseCaseImpl(private val repository: MoviesRepository): GetMoviesForUIUseCase {
    override suspend fun getMovies(): List<MovieModel> {
        return repository.getMovies()
    }

    override suspend fun getRatedMovies(): List<MovieModel> {
        return repository.getRatedMovies()
    }
}