package com.muzafferus.newsapicliend.presentation.viewmodel.di

import com.muzafferus.newsapicliend.data.api.NewsAPIService
import com.muzafferus.newsapicliend.data.repository.dataSource.NewsRemoteDataSource
import com.muzafferus.newsapicliend.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(newsAPIService: NewsAPIService):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}