package com.muzafferus.tmdbclient.domain.usecase

import com.muzafferus.tmdbclient.domain.repository.TvShowRepository
import com.muzafferus.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowsRepository.updateTvShows()
}