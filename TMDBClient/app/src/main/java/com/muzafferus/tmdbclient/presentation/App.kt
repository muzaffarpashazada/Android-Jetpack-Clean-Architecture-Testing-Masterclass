package com.muzafferus.tmdbclient.presentation

import android.app.Application
import com.muzafferus.tmdbclient.BuildConfig
import com.muzafferus.tmdbclient.presentation.di.Injector
import com.muzafferus.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.muzafferus.tmdbclient.presentation.di.core.*
import com.muzafferus.tmdbclient.presentation.di.movie.MovieSubComponent
import com.muzafferus.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import javax.inject.Inject

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

            appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule(BuildConfig.BASE_URL))
                .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
                .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
       return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}