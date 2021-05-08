package com.muzafferus.tmdbclient.data.repository.movie.datasourceImpl

import com.muzafferus.tmdbclient.data.api.TMDBService
import com.muzafferus.tmdbclient.data.model.movie.MovieList
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}