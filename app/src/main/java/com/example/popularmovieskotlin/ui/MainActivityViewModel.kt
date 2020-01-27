package com.example.popularmovieskotlin.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popularmovieskotlin.database.MovieRepository
import com.example.popularmovieskotlin.model.MovieDetail
import com.example.popularmovieskotlin.model.MovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepo = MovieRepository()
    val error = MutableLiveData<String>()
    val movies = MutableLiveData<List<MovieDetail>>()

    fun getMovies(year: String) {
        movieRepo.getMovies(year).enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful) movies.value = response.body()?.movielist
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}