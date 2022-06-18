package com.example.imdb_project.data.mappers

import com.example.imdb_project.data.dto.MovieDto
import com.example.imdb_project.domain.models.MovieModel

class MovieListMapper {
    fun mapMovieDtoList2MovieModelList(movieList: List<MovieDto>): List<MovieModel> {
        val movies = mutableListOf<MovieModel>()
        movieList.forEach { movieDto ->
            movies.add(
                MovieModel(
                    title = movieDto.title,
                    description = movieDto.description,
                    thumbnail = movieDto.thumbnail,
                    preview = movieDto.preview,
                    actors = movieDto.actors,
                    rating = movieDto.rating,
                    numberOfEpisodes = movieDto.numberOfEpisodes,
                    year = movieDto.year
                )
            )
        }
        return movies
    }
}