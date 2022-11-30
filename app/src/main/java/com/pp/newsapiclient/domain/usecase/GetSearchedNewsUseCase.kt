package com.pp.newsapiclient.domain.usecase

import com.pp.newsapiclient.data.model.APIResponse
import com.pp.newsapiclient.data.util.Resource
import com.pp.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
     suspend fun execute(country:String,searchQuery:String,page:Int): Resource<APIResponse>{
         return newsRepository.getSearchedNews(country,searchQuery,page)
     }
}