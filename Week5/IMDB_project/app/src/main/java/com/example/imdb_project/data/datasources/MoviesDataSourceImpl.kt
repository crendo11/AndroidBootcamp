package com.example.imdb_project.data.datasources

import com.example.imdb_project.data.dto.MovieListResponse
import com.example.imdb_project.data.dto.MovieRatedResponse
import com.example.imdb_project.data.services.ImdbApi


class MoviesDataSourceImpl: MoviesDataSource {
    override suspend fun getMovies(): MovieListResponse{
        return ImdbApi.retrofitService.getMoviesList()
    }

    override suspend fun getRatedMovies(): MovieRatedResponse {
        return ImdbApi.retrofitService.getTopRated()
    }
}