package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.data.model.Article
import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)

}