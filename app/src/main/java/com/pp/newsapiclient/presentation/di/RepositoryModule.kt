package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.api.NewsAPIService
import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.repository.NewsRepository
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
        articleDAO: ArticleDAO
    ): NewsRepository {
        return NewsRepository(
            newsAPIService,
            articleDAO
        )
    }

}














