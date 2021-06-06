package com.muzafferus.tmdbclient.data.repository.movie

import com.muzafferus.tmdbclient.data.model.movie.Movie
import com.muzafferus.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.addAll(
            listOf(
                Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"),
                Movie(2, "overview2", "posterPath2", "releaseDate2", "title2")
            )
        )
    }

    override suspend fun getMovies(): List<Movie> {
        return movies
    }

    override suspend fun updateMovies(): List<Movie> {
        movies.clear()
        movies.addAll(
            listOf(
                Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"),
                Movie(4, "overview4", "posterPath4", "releaseDate4", "title4"),
                Movie(5, "overview5", "posterPath4", "releaseDate5", "title5")
            )
        )

        return movies
    }
}