package com.muzafferus.newsapicliend.data.repository.dataSource

import com.muzafferus.newsapicliend.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>
}