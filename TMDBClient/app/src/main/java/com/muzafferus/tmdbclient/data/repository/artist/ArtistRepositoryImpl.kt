package com.muzafferus.tmdbclient.data.repository.artist

import android.util.Log
import com.muzafferus.tmdbclient.data.domain.repository.ArtistRepository
import com.muzafferus.tmdbclient.data.model.artist.Artist
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        var artistList: List<Artist> = listOf()

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            body?.let { artistList = it.artists }
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        var artistList: List<Artist> = listOf()

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        var artistList: List<Artist> = listOf()

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

}