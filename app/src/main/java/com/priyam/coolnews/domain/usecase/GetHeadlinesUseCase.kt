package com.priyam.coolnews.domain.usecase

import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.util.Resource
import com.priyam.coolnews.domain.repository.NewsRepository

class GetHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country:String , page:Int): Resource<APIResponse>{
        return  newsRepository.getNewsHeadlines()
    }
}