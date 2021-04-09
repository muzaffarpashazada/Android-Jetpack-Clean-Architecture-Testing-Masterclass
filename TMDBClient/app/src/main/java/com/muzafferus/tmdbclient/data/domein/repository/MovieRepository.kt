package com.muzafferus.tmdbclient.data.domein.repository

import com.muzafferus.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}