package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.data.model.Article
import com.muzafferus.newsapicliend.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}