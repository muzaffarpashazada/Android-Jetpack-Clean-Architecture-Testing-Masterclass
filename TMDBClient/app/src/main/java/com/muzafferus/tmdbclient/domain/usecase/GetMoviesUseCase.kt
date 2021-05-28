package com.muzafferus.tmdbclient.domain.usecase

import com.muzafferus.tmdbclient.domain.repository.MovieRepository
import com.muzafferus.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}