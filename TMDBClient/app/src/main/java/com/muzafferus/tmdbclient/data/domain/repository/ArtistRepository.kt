package com.muzafferus.tmdbclient.data.domain.repository

import com.muzafferus.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}