package com.muzafferus.tmdbclient.presentation.di.core

import android.content.Context
import com.muzafferus.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.muzafferus.tmdbclient.presentation.di.movie.MovieSubComponent
import com.muzafferus.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [TvShowSubComponent::class, MovieSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}