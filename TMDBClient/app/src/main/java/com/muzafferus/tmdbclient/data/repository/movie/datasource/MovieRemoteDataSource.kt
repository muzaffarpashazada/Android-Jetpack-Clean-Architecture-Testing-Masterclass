package com.muzafferus.tmdbclient.data.repository.movie.datasource

import com.muzafferus.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}