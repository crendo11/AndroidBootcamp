package com.example.imdb_project.domain.models

import android.net.Uri

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