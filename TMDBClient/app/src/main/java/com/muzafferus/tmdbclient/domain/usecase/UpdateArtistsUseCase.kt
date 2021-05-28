package com.muzafferus.tmdbclient.domain.usecase

import com.muzafferus.tmdbclient.domain.repository.ArtistRepository
import com.muzafferus.tmdbclient.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}