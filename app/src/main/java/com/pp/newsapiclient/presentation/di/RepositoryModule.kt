package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.repository.NewsRepository
import com.pp.newsapiclient.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import com.pp.newsapiclient.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
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
        newsRemoteDataSource: NewsRemoteDataSourceImpl,
        newsLocalDataSource: NewsLocalDataSourceImpl
    ): NewsRepository {
        return NewsRepository(
            newsRemoteDataSource,
            newsLocalDataSource
        )
    }

}














