package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class GetNewsHeadlineUseCase(private val newsRepository: NewsRepository) {
}