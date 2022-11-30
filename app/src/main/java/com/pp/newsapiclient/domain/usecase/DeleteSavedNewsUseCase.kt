package com.pp.newsapiclient.domain.usecase

import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.data.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)=newsRepository.deleteNews(article)
}