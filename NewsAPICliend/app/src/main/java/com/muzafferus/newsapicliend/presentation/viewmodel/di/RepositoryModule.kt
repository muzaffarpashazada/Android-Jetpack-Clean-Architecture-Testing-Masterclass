package com.muzafferus.newsapicliend.presentation.viewmodel.di

import com.muzafferus.newsapicliend.data.repository.NewsRepositoryImpl
import com.muzafferus.newsapicliend.data.repository.dataSource.NewsRemoteDataSource
import com.muzafferus.newsapicliend.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}