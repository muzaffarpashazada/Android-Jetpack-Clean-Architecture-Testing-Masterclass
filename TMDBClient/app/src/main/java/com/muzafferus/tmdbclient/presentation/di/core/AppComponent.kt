package com.muzafferus.tmdbclient.presentation.di.core

import com.muzafferus.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.muzafferus.tmdbclient.presentation.di.movie.MovieSubComponent
import com.muzafferus.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDatModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory

}