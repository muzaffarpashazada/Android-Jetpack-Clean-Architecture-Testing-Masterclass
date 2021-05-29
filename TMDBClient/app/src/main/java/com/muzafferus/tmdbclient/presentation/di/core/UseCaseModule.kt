package com.muzafferus.tmdbclient.presentation.di.core

import com.muzafferus.tmdbclient.domain.repository.ArtistRepository
import com.muzafferus.tmdbclient.domain.repository.MovieRepository
import com.muzafferus.tmdbclient.domain.repository.TvShowRepository
import com.muzafferus.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }


}