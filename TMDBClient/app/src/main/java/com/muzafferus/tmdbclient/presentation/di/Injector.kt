package com.muzafferus.tmdbclient.presentation.di

import com.muzafferus.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.muzafferus.tmdbclient.presentation.di.movie.MovieSubComponent
import com.muzafferus.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}