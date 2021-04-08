package com.muzafferus.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muzafferus.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: Artist)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist(artists: List<Artist>)

}