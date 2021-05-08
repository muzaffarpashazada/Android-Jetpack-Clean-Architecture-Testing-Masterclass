package com.muzafferus.tmdbclient.data.repository.tvshow

import android.util.Log
import com.muzafferus.tmdbclient.data.domain.repository.TvShowRepository
import com.muzafferus.tmdbclient.data.model.tvshow.TvShow
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.muzafferus.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTwShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        var tvShowList: List<TvShow> = listOf()

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            body?.let { tvShowList = it.tvShows }
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        var tvShowList: List<TvShow> = listOf()

        try {
            tvShowList = tvShowLocalDataSource.getTwShowsFromDB()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTwShowsToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        var tvShowList: List<TvShow> = listOf()

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.e("Muzafferus", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

}