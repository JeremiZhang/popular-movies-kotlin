package com.example.popularmovieskotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.popularmovieskotlin.R
import com.example.popularmovieskotlin.model.MovieDetail
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews() {
        val movie = intent.getParcelableExtra<MovieDetail>("Movie")
        Glide.with(this).load(movie?.getBackdropUrl()).into(ivBackdrop)
        Glide.with(this).load(movie?.getPosterUrl()).into(ivPoster)
        tvTitle.text = movie?.title
        tvRelease.text = movie?.releaseDate
        tvRating.text = movie?.voteAverage
        tvDescription.text = movie?.overview
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
