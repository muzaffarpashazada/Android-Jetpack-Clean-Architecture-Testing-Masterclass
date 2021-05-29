package com.muzafferus.tmdbclient.presentation.di.core

import com.muzafferus.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.muzafferus.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.muzafferus.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.muzafferus.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.muzafferus.tmdbclient.domain.repository.ArtistRepository
import com.muzafferus.tmdbclient.domain.repository.MovieRepository
import com.muzafferus.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}