package com.muzafferus.tmdbclient.domain.repository

import com.muzafferus.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}