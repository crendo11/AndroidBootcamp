package com.example.imdb_project.data.datasources

import android.content.res.Resources
import com.example.imdb_project.R
import com.example.imdb_project.data.dto.MovieDto

class MoviesDataSourceImpl: MoviesDataSource {
    override fun getMovies(): List<MovieDto>{
        return listOf(
            MovieDto(
                title = "How to Train Your Dragon",
                year = 2010,
                actors = listOf("Jay Baruchel", "America Ferrera"),
                description = "Hiccup, a teenage Viking, begins dragon training classes, and " +
                        "finally sees an opportunity to prove he is capable of becoming a warrior when he befriends " +
                        "a wounded dragon",
                rating = 5F,
                thumbnail = R.drawable.httyd,
                numberOfEpisodes = 1,
                preview = R.drawable.httyd_preview
            ),
            MovieDto(
                title = "Queen of the South",
                year = 2016,
                actors = listOf("Alice Braga", "Hemky Madera"),
                description = "Teresa Mendoza, a woman from a poor neighborhood, " +
                        "falls in love with a drug lord in Jalisco. When he is murdered, she is forced to go to " +
                        "the United States, where she becomes a wealthy drug trafficker in search of revenge, " +
                        "always on the run from death.",
                rating = 4.2F,
                thumbnail = R.drawable.queen_south,
                numberOfEpisodes = 3,
                preview = R.drawable.queen_south_preview
            ),
            MovieDto(
                title = "The Queens Gambit",
                year = 2020,
                actors = listOf("Anya Taylor-Joy", "Thomas Brodie"),
                description = "Orphan and chess prodigy, Beth Harmon, struggles with " +
                        "addiction as she seeks to become the world\'s best chess player",
                rating = 5F,
                thumbnail = R.drawable.queens_gambit,
                numberOfEpisodes = 7,
                preview = R.drawable.queens_gambit_preview
            ),
            MovieDto(
                title = "Queen Sugar",
                year = 2016,
                actors = listOf("Rutina Wesley", "Dawn-Lyen Gardner"),
                description = "The Bordelon brothers must put aside their complicated " +
                        "lives in order to unite and manage the clan\'s sugarcane farm.",
                rating = 3.9F,
                thumbnail = R.drawable.queen_sugar,
                numberOfEpisodes = 8,
                preview = R.drawable.queen_sugar_preview
            ),
            MovieDto(
                title = "Queenpins",
                year = 2021,
                actors = listOf("Kirsten Bell", "Kirby Howell-Baptiste"),
                description = ">Two housewives organize a scam that steals millions of " +
                        "dollars from big companies through discount coupons. A policeman and a postal inspector " +
                        "will try to stop the daring scammers.",
                rating = 5F,
                thumbnail = R.drawable.queenpins,
                numberOfEpisodes = 3,
                preview = R.drawable.queenpins_preview
            )
        )
    }
}