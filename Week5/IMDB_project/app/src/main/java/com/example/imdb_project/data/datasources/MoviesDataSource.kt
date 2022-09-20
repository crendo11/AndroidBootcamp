package com.example.imdb_project.data.datasources

import com.example.imdb_project.data.dto.MovieListResponse
import com.example.imdb_project.data.dto.MovieRatedResponse

interface MoviesDataSource {
    suspend fun getMovies(): MovieListResponse
    suspend fun getRatedMovies(): MovieRatedResponse
}