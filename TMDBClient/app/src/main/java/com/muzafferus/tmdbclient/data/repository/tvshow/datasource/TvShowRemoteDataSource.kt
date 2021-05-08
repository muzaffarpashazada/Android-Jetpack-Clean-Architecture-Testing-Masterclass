package com.muzafferus.tmdbclient.data.repository.tvshow.datasource

import com.muzafferus.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}