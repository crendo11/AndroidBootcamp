package com.example.imdb_project.data.datasources

import com.example.imdb_project.data.dto.MovieDto
import com.example.imdb_project.data.dto.MovieListResponse
import com.example.imdb_project.data.services.ImdbApi


class MoviesDataSourceImpl: MoviesDataSource {
    override suspend fun getMovies(): MovieListResponse{
        return ImdbApi.retrofitService.getMoviesList()
    }
}