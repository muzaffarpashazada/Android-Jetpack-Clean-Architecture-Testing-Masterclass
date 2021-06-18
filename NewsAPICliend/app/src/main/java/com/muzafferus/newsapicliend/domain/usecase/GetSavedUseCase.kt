package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class GetSavedUseCase(private val newsRepository: NewsRepository) {
}