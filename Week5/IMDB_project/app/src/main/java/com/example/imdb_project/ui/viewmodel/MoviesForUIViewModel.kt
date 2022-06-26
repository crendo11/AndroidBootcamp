package com.example.imdb_project.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_project.data.datasources.MoviesDataSourceImpl
import com.example.imdb_project.data.repositories.MoviesRepositoryImpl
import com.example.imdb_project.domain.models.MovieModel
import com.example.imdb_project.domain.usecases.GetMoviesForUIUseCaseImpl
import kotlinx.coroutines.launch

class MoviesForUIViewModel: ViewModel() {
    // this should not be done like this. This is a temporal solution
    private val useCase = GetMoviesForUIUseCaseImpl(MoviesRepositoryImpl(MoviesDataSourceImpl()))

    // create live data
    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies: LiveData<List<MovieModel>> = _movies
    private val _ratedMovies = MutableLiveData<List<MovieModel>>()
    val ratedMovies: LiveData<List<MovieModel>> = _ratedMovies

    fun getMoviesList(){
        viewModelScope.launch {
            try {
                _movies.value = useCase.getMovies()
            } catch (e: Exception) {
                _movies.value = listOf()
            }
        }
    }

    fun getTopRatedMovies(){
        viewModelScope.launch {
            try{
                _ratedMovies.value = useCase.getRatedMovies()
            } catch (e: Exception) {
                _ratedMovies.value = listOf()
            }
        }
    }


}