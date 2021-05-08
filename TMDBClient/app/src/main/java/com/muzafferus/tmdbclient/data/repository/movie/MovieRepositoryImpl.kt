package com.muzafferus.tmdbclient.data.repository.movie

import android.util.Log
import com.muzafferus.tmdbclient.data.domain.repository.MovieRepository
import com.muzafferus.tmdbclient.data.model.movie.Movie
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearALl()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }


    private suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList: List<Movie> = listOf()

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            body?.let { movieList = it.movies }
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        var movieList: List<Movie> = listOf()

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList: List<Movie> = listOf()

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}