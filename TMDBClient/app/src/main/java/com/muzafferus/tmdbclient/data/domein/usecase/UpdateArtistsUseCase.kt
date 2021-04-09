package com.muzafferus.tmdbclient.data.domein.usecase

import com.muzafferus.tmdbclient.data.domein.repository.ArtistRepository
import com.muzafferus.tmdbclient.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}