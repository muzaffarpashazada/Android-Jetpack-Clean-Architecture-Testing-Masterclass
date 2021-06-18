package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}