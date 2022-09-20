package com.example.imdb_project.domain.models

data class MovieModel (
    val title: String,
    val overview: String,
    val actors: List<String>,
    val releaseDate: String,
    val rating: Float,
    val thumbnail: String,
    val preview: String,
    val numberOfEpisodes: Int
)