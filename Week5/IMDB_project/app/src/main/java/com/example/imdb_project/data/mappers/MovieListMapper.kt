package com.example.imdb_project.data.mappers

import android.net.Uri
import androidx.core.net.toUri
import com.example.imdb_project.data.dto.MovieDto
import com.example.imdb_project.data.dto.MovieListResponse
import com.example.imdb_project.data.dto.MovieRatedResponse
import com.example.imdb_project.domain.models.MovieModel

class MovieListMapper {
    fun mapMovieDtoList2MovieModelList(movieList: MovieListResponse): List<MovieModel> {
        val movies = mutableListOf<MovieModel>()
        movieList.items.forEach { movieDto ->
            movies.add(
                MovieModel(
                    title = movieDto.title,
                    overview = movieDto.overview,
                    thumbnail = imageUrl2imageUri(movieDto.thumbnail),
                    preview = imageUrl2imageUri(movieDto.preview),
                    actors = listOf(),
                    rating = movieDto.rating,
                    numberOfEpisodes = 1,
                    releaseDate = movieDto.releaseDate
                )
            )
        }
        return movies
    }

    fun mapMovieRatedList2MovieModelList(movieList: MovieRatedResponse): List<MovieModel> {
        val movies = mutableListOf<MovieModel>()
        movieList.results.forEach { movieDto ->
            movies.add(
                MovieModel(
                    title = movieDto.title,
                    overview = movieDto.overview,
                    thumbnail = imageUrl2imageUri(movieDto.thumbnail),
                    preview = imageUrl2imageUri(movieDto.preview),
                    actors = listOf(),
                    rating = movieDto.rating,
                    numberOfEpisodes = 1,
                    releaseDate = movieDto.releaseDate
                )
            )
        }
        return movies
    }

    private fun imageUrl2imageUri(imagePath: String): String {
        val baseUrl = "https://image.tmdb.org/t/p/w500"
        val imageUrl = baseUrl+imagePath
        return imageUrl.toUri().buildUpon().scheme("https").build().toString()
    }
}