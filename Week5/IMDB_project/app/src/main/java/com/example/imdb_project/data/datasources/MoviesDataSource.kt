package com.example.imdb_project.data.datasources

import com.example.imdb_project.data.dto.MovieDto
import com.example.imdb_project.data.dto.MovieListResponse

interface MoviesDataSource {
    suspend fun getMovies(): MovieListResponse
}