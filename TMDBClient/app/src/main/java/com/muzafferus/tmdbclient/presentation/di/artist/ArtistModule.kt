package com.muzafferus.tmdbclient.presentation.di.artist

import com.muzafferus.tmdbclient.domain.usecase.GetArtistUseCase
import com.muzafferus.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.muzafferus.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistsUseCase)
    }

}