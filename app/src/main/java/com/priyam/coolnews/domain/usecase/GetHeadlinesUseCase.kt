package com.priyam.coolnews.domain.usecase

import com.priyam.coolnews.domain.repository.NewsRepository

class GetHeadlinesUseCase(private val newsRepository: NewsRepository) {
}