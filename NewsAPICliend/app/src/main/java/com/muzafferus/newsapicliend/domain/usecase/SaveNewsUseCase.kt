package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.data.model.Article
import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)

}