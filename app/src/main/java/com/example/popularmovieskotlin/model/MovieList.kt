package com.example.popularmovieskotlin.model

import com.google.gson.annotations.SerializedName

data class MovieList(@SerializedName("results") var movielist: List<MovieDetail>)