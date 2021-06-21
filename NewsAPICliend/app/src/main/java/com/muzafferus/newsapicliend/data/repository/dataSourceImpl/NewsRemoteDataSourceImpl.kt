package com.muzafferus.newsapicliend.data.repository.dataSourceImpl

import com.muzafferus.newsapicliend.data.api.NewsAPIService
import com.muzafferus.newsapicliend.data.model.APIResponse
import com.muzafferus.newsapicliend.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getHeadlines(country, page)
    }
}