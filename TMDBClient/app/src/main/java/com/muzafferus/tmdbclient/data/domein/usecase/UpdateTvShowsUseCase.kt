package com.muzafferus.tmdbclient.data.domein.usecase

import com.muzafferus.tmdbclient.data.domein.repository.TvShowRepository
import com.muzafferus.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowsRepository.updateTvShows()
}