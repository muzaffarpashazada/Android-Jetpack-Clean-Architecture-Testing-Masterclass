package com.muzafferus.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muzafferus.tmdbclient.data.model.artist.Artist
import com.muzafferus.tmdbclient.data.model.movie.Movie
import com.muzafferus.tmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao
}