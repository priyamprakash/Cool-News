package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: ArticleDAO):NewsLocalDataSource{
      return NewsLocalDataSource(articleDAO)
    }

}













