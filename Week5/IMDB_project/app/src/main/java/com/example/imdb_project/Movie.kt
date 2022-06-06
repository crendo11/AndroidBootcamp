package com.example.imdb_project

data class Movie (
    val title: String,
    val description: String,
    val actors: List<String>,
    val year: Int,
    val rating: Float,
    val thumbnail: Int
)