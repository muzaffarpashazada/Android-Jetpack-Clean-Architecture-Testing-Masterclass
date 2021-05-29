package com.muzafferus.tmdbclient.domain.usecase

import com.muzafferus.tmdbclient.data.model.tvshow.TvShow
import com.muzafferus.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}