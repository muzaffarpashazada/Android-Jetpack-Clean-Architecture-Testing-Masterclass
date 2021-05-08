package com.muzafferus.tmdbclient.data.repository.artist.datasource

import com.muzafferus.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}