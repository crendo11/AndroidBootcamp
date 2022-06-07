package com.example.imdb_project

import android.content.Context

data class Movies(val context: Context) {
    val movies: List<Movie> = listOf(
        Movie(
            title = context.getString(R.string.title_httyd),
            year = 2010,
            actors = listOf("Jay Baruchel", "America Ferrera"),
            description = context.getString(R.string.description_httyd),
            rating = 5F,
            thumbnail = R.drawable.httyd
        ),
        Movie(
            title = context.getString(R.string.queen_south_title),
            year = 2016,
            actors = listOf("Alice Braga", "Hemky Madera"),
            description = context.getString(R.string.description_queen_south),
            rating = 4.2F,
            thumbnail = R.drawable.queen_south
        ),
        Movie(
            title = "The Queens Gambit",
            year = 2020,
            actors = listOf("Anya Taylor-Joy", "Thomas Brodie"),
            description = "Queens gambit description or synopsis",
            rating = 5F,
            thumbnail = R.drawable.queens_gambit
        ),
        Movie(
            title = "Queen Sugar",
            year = 2016,
            actors = listOf("Rutina Wesley", "Dawn-Lyen Gardner"),
            description = "Queen sugar synopsis",
            rating = 3.9F,
            thumbnail = R.drawable.queen_sugar
        ),
        Movie(
            title = "Queenpins",
            year = 2021,
            actors = listOf("Kirsten Bell", "Kirby Howell-Baptiste"),
            description = "Queenpins Synopsis",
            rating = 5F,
            thumbnail = R.drawable.queenpins
        )
    )
}