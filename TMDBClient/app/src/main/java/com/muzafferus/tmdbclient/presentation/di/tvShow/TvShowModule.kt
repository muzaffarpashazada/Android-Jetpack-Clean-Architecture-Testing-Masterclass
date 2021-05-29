package com.muzafferus.tmdbclient.presentation.di.tvShow

import com.muzafferus.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.muzafferus.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.muzafferus.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}