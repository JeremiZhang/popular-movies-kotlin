package com.example.popularmovieskotlin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.popularmovieskotlin.R
import com.example.popularmovieskotlin.model.MovieDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieDetail>()
    private val movieAdapter = MovieAdapter(movies) { movie -> onMovieClicked(movie) }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvMovies.layoutManager =
            GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)
        rvMovies.adapter = movieAdapter

        btnSubmit.setOnClickListener {
            viewModel.getMovies(etYear.text.toString())
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun onMovieClicked(movie: MovieDetail) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Movie", movie)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
