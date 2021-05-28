package com.muzafferus.tmdbclient.domain.repository

import com.muzafferus.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}