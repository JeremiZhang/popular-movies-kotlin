package com.example.popularmovieskotlin.database

import com.example.popularmovieskotlin.api.MovieApi

class MovieRepository {
    private val movieApi = MovieApi.createApi()

    fun getMovies(year: String) = movieApi.getMovies(year)
}
