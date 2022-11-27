package com.priyam.coolnews.domain.usecase

import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.util.Resource
import com.priyam.coolnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery:String): Resource<APIResponse>{
        return  newsRepository.getSearchedNews(searchQuery)
    }
}