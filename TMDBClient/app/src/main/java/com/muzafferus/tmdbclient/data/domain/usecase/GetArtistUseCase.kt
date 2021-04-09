package com.muzafferus.tmdbclient.data.domain.usecase

import com.muzafferus.tmdbclient.data.domain.repository.ArtistRepository
import com.muzafferus.tmdbclient.data.model.artist.Artist

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}