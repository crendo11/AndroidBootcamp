package com.example.imdb_project.data.services

import com.example.imdb_project.data.dto.MovieListResponse
import com.example.imdb_project.data.dto.MovieDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "c5c47722a4adcc77f6e84f28a48b857a"

// moshi builder
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// retrofit builder
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ImdbApiService{
    @GET("movie/top_rated?api_key=${API_KEY}")
    suspend fun getTopRated(): List<MovieDto>

    @GET("list/1?api_key=${API_KEY}")
    suspend fun getMoviesList(): MovieListResponse
}

object ImdbApi{
    val retrofitService: ImdbApiService by lazy {
        retrofit.create(ImdbApiService::class.java)
    }
}
