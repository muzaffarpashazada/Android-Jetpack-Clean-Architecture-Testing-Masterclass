package com.muzafferus.tmdbclient.data.repository.artist.datasourceImpl

import com.muzafferus.tmdbclient.data.db.ArtistDao
import com.muzafferus.tmdbclient.data.model.artist.Artist
import com.muzafferus.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtist()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        artistDao.deleteAllArtists()
    }
}