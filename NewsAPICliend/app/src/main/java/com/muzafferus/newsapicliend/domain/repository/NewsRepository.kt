package com.muzafferus.newsapicliend.domain.repository

import com.muzafferus.newsapicliend.data.model.APIResponse
import com.muzafferus.newsapicliend.data.model.Article
import com.muzafferus.newsapicliend.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}