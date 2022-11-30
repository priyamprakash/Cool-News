package com.pp.newsapiclient.presentation.di

import android.app.Application
import com.pp.newsapiclient.data.repository.NewsRepository
import com.pp.newsapiclient.domain.usecase.*
import com.pp.newsapiclient.presentation.viewmodel.NewsViewModelFactory
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
     application: Application,
     newsRepository: NewsRepository
  ):NewsViewModelFactory{
      return NewsViewModelFactory(
          application,
          newsRepository
      )
  }

}








