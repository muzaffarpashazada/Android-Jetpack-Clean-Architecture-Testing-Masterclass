package com.muzafferus.newsapicliend.presentation.viewmodel.di

import android.app.Application
import com.muzafferus.newsapicliend.domain.usecase.GetNewsHeadlinesUseCase
import com.muzafferus.newsapicliend.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlinesUseCase)
    }
}