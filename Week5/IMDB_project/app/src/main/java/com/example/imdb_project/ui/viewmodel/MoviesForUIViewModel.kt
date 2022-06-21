package com.example.imdb_project.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imdb_project.data.datasources.MoviesDataSourceImpl
import com.example.imdb_project.data.repositories.MoviesRepositoryImpl
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.domain.usecases.GetMoviesForUIUseCaseImpl

class MoviesForUIViewModel: ViewModel() {
    // this should not be done like this. This is a temporal solution
    private val useCase = GetMoviesForUIUseCaseImpl(MoviesRepositoryImpl(MoviesDataSourceImpl()))

    // create live data
    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies: LiveData<List<MovieModel>> = _movies

    fun setView(){
        _movies.value = useCase.getMovies()
    }


}