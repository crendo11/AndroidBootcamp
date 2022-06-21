package com.example.imdb_project.data.dto

import com.squareup.moshi.Json

data class MovieDto (
    val title: String,
    val overview: String,
    //val actors: List<String>,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "vote_average") val rating: Float,
    @Json(name = "poster_path") val thumbnail: String,
    @Json(name = "backdrop_path") val preview: String,
    //val numberOfEpisodes: Int
)