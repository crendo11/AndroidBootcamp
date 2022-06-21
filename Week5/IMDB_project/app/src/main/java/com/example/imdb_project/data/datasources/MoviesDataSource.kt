package com.example.imdb_project.data.datasources

import com.example.imdb_project.data.dto.MovieDto

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}