package com.example.imdb_project

import android.content.Context
import com.example.imdb_project.domain.models.MovieModel

data class Movies(val context: Context) {
    val movieModels: List<MovieModel> = listOf(
        MovieModel(
            title = context.getString(R.string.title_httyd),
            year = 2010,
            actors = listOf("Jay Baruchel", "America Ferrera"),
            description = context.getString(R.string.httyd_synopsis),
            rating = 5F,
            thumbnail = R.drawable.httyd,
            numberOfEpisodes = 1,
            preview = R.drawable.httyd_preview
        ),
        MovieModel(
            title = context.getString(R.string.queen_south_title),
            year = 2016,
            actors = listOf("Alice Braga", "Hemky Madera"),
            description = context.getString(R.string.queen_south_synopsis),
            rating = 4.2F,
            thumbnail = R.drawable.queen_south,
            numberOfEpisodes = 3,
            preview = R.drawable.queen_south_preview
        ),
        MovieModel(
            title = "The Queens Gambit",
            year = 2020,
            actors = listOf("Anya Taylor-Joy", "Thomas Brodie"),
            description = context.getString(R.string.queens_gambit_synopsis),
            rating = 5F,
            thumbnail = R.drawable.queens_gambit,
            numberOfEpisodes = 7,
            preview = R.drawable.queens_gambit_preview
        ),
        MovieModel(
            title = "Queen Sugar",
            year = 2016,
            actors = listOf("Rutina Wesley", "Dawn-Lyen Gardner"),
            description = context.getString(R.string.queen_sugar_synopsis),
            rating = 3.9F,
            thumbnail = R.drawable.queen_sugar,
            numberOfEpisodes = 8,
            preview = R.drawable.queen_sugar_preview
        ),
        MovieModel(
            title = "Queenpins",
            year = 2021,
            actors = listOf("Kirsten Bell", "Kirby Howell-Baptiste"),
            description = context.getString(R.string.queenpins_synopsis),
            rating = 5F,
            thumbnail = R.drawable.queenpins,
            numberOfEpisodes = 3,
            preview = R.drawable.queenpins_preview
        )
    )
}