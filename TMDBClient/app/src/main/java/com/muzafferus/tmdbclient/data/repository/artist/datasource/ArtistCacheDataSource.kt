package com.muzafferus.tmdbclient.data.repository.artist.datasource

import com.muzafferus.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}