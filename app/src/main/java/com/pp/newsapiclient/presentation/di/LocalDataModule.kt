package com.pp.newsapiclient.presentation.di

import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
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
    fun provideLocalDataSource(articleDAO: ArticleDAO):NewsLocalDataSourceImpl{
      return NewsLocalDataSourceImpl(articleDAO)
    }

}













