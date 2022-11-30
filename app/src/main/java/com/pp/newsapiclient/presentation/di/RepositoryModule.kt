package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.api.NewsAPIService
import com.pp.newsapiclient.data.repository.NewsRepository
import com.pp.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import com.pp.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
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
    fun provideNewsRepository(
        newsAPIService: NewsAPIService,
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepository(
            newsAPIService,
            newsRemoteDataSource,
            newsLocalDataSource
        )
    }

}














