package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}