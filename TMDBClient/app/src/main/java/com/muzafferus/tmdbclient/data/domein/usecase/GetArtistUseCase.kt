package com.muzafferus.tmdbclient.data.domein.usecase

import com.muzafferus.tmdbclient.data.domein.repository.ArtistRepository
import com.muzafferus.tmdbclient.data.model.artist.Artist

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}