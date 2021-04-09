package com.muzafferus.tmdbclient.data.domein.usecase

import com.muzafferus.tmdbclient.data.domein.repository.MovieRepository
import com.muzafferus.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}