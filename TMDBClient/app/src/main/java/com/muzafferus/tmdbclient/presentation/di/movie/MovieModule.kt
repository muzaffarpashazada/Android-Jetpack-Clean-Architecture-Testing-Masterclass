package com.muzafferus.tmdbclient.presentation.di.movie

import com.muzafferus.tmdbclient.domain.usecase.GetMoviesUseCase
import com.muzafferus.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.muzafferus.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}