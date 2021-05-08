package com.muzafferus.tmdbclient.data.repository.movie.datasourceImpl

import com.muzafferus.tmdbclient.data.db.MovieDao
import com.muzafferus.tmdbclient.data.model.movie.Movie
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
      CoroutineScope(Dispatchers.IO).launch{
          movieDao.saveMovies(movies)
      }
    }

    override suspend fun clearAll() {
        movieDao.deleteAllMovies()
    }
}