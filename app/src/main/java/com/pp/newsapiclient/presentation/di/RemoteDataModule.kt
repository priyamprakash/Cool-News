package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.api.NewsAPIService
import com.pp.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ):NewsRemoteDataSource{
       return NewsRemoteDataSource(newsAPIService)
    }

}












