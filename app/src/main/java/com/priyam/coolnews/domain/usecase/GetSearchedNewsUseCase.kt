package com.priyam.coolnews.domain.usecase

import com.priyam.coolnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}