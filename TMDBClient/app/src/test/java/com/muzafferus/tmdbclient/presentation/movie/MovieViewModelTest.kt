package com.muzafferus.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.muzafferus.tmdbclient.data.model.movie.Movie
import com.muzafferus.tmdbclient.data.repository.movie.FakeMovieRepository
import com.muzafferus.tmdbclient.domain.repository.MovieRepository
import com.muzafferus.tmdbclient.domain.usecase.GetMoviesUseCase
import com.muzafferus.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.muzafferus.tmdbclient.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private lateinit var updateMoviesUseCase: UpdateMoviesUseCase
    private lateinit var fakeMovieRepository: MovieRepository

    @Before
    fun setUp() {
        fakeMovieRepository = FakeMovieRepository()
        getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(
            listOf(
                Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"),
                Movie(2, "overview2", "posterPath2", "releaseDate2", "title2")
            )
        )

        val currentlyList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentlyList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.addAll(
            listOf(
                Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"),
                Movie(4, "overview4", "posterPath4", "releaseDate4", "title4"),
                Movie(5, "overview5", "posterPath4", "releaseDate5", "title5")
            )
        )

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }


}