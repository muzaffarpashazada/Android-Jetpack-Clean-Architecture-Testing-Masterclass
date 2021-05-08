package com.muzafferus.tmdbclient.data.repository.tvshow.datasource

import com.muzafferus.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTwShowsFromDB(): List<TvShow>
    suspend fun saveTwShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}