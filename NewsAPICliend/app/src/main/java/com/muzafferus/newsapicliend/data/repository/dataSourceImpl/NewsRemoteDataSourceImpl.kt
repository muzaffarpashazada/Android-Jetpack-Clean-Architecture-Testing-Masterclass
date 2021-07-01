package com.muzafferus.newsapicliend.data.repository.dataSourceImpl

import com.muzafferus.newsapicliend.data.api.NewsAPIService
import com.muzafferus.newsapicliend.data.model.APIResponse
import com.muzafferus.newsapicliend.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getHeadlines(country, page)
    }
}