package com.muzafferus.newsapicliend.domain.usecase

import com.muzafferus.newsapicliend.data.model.APIResponse
import com.muzafferus.newsapicliend.data.util.Resource
import com.muzafferus.newsapicliend.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchNews(searchQuery)
    }
}