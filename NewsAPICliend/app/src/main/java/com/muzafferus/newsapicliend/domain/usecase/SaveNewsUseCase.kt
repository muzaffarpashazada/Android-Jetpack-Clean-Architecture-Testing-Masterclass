package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}