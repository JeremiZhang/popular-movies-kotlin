package com.example.popularmovieskotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popularmovieskotlin.R
import com.example.popularmovieskotlin.model.MovieDetail
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(
    private val movies: List<MovieDetail>,
    private val onClick: (MovieDetail) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: MovieDetail) {
            Glide.with(context).load(movie.getPosterUrl())
                .into(itemView.ivMovie)
        }
    }
}