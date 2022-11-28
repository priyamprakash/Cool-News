package com.priyam.coolnews.presentation.di


import com.priyam.coolnews.data.repository.NewsRepositoryImpl
import com.priyam.coolnews.data.repository.dataSource.NewsRemoteDataSource
import com.priyam.coolnews.domain.repository.NewsRepository
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
        newsRemoteDataSource: NewsRemoteDataSource,
    ): NewsRepository {
        return NewsRepositoryImpl(
            newsRemoteDataSource
        )
    }

}














