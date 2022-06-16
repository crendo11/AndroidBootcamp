package com.example.imdb_project.data.dto

data class MovieDto (
    val title: String,
    val description: String,
    val actors: List<String>,
    val year: Int,
    val rating: Float,
    val thumbnail: Int,
    val preview: Int,
    val numberOfEpisodes: Int
)