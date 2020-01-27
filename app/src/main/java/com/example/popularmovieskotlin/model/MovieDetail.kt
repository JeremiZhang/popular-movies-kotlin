package com.example.popularmovieskotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetail(
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var voteAverage: String,
    @SerializedName("overview") var overview: String
) : Parcelable {
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/original$backdropPath"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/original$posterPath"
}