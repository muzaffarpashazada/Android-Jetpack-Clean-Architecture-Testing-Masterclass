package com.muzafferus.tmdbclient.data.repository.tvshow.datasourceImpl

import com.muzafferus.tmdbclient.data.db.TvShowDao
import com.muzafferus.tmdbclient.data.model.tvshow.TvShow
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {

    override suspend fun getTwShowsFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTwShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvShows()
    }
}