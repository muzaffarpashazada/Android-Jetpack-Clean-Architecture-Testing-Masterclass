package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.data.model.APIResponse
import com.muzafferus.newsapicliend.data.util.Resource
import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }
}