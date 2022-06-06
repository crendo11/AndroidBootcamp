package com.example.imdb_project

data class Movies(
    val movies: List<Movie> = listOf(
        Movie(
            title = "How to train your dragon",
            year = 2010,
            actors = listOf("Jay Baruchel", "America Ferrera"),
            description = "briej movie description",
            rating = 5F,
            thumbnail = R.drawable.httyd
        )
    )
)