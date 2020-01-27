package com.example.popularmovieskotlin.api

import com.example.popularmovieskotlin.BuildConfig.API_KEY
import com.example.popularmovieskotlin.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    // The GET method needed to retrieve the movies.
    @GET("discover/movie?api_key=$API_KEY&include_video=false&page=1")
    fun getMovies(@Query("year") year: String): Call<MovieList>
}