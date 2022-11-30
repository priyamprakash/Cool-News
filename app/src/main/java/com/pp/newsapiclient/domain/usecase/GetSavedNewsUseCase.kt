package com.pp.newsapiclient.domain.usecase

import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}