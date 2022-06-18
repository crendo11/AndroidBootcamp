package com.example.imdb_project.data.repositories

import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.data.datasources.MoviesDataSource
import com.example.imdb_project.data.mappers.MovieListMapper

// The repository is in charge of select the datasource (local or cloud)
// The repository is in charge of executing transformations of data
class MoviesRepositoryImpl(private val dataSource: MoviesDataSource): MoviesRepository {
    override fun getMovies(): List<MovieModel> {
        val dto = dataSource.getMovies()
        val mapper = MovieListMapper()
        return mapper.mapMovieDtoList2MovieModelList(dto)
    }
}