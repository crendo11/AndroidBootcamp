package com.example.imdb_project.data.repositories

import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.data.datasources.MoviesDataSource

// The repository is in charge of select the datasource (local or cloud)
// The repository is in charge of executing transformations of data
class MoviesRepositoryImpl(private val dataSource: MoviesDataSource): MoviesRepository {
    override fun getMovies(): List<MovieModel> {
        val dto = dataSource.getMovies()
        val movies = mutableListOf<MovieModel>()
        dto.forEach{ movieDto ->
            movies.add( MovieModel(
                title = movieDto.title,
                description = movieDto.description,
                thumbnail = movieDto.thumbnail,
                preview = movieDto.preview,
                actors = movieDto.actors,
                rating = movieDto.rating,
                numberOfEpisodes = movieDto.numberOfEpisodes,
                year = movieDto.year
            ))
        }
        return movies
    }
}