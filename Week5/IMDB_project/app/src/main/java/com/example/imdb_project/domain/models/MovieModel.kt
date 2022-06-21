package com.example.imdb_project.domain.models

data class MovieModel (
    val title: String,
    val description: String,
    val actors: List<String>,
    val year: Int,
    val rating: Float,
    val thumbnail: Int,
    val preview: Int,
    val numberOfEpisodes: Int
)