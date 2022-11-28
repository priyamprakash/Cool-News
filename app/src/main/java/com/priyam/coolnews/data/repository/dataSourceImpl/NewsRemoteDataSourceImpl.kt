package com.priyam.coolnews.data.repository.dataSourceImpl

import com.priyam.coolnews.data.api.NewsApiService
import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,


):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
        return newsApiService.getTopHeadlines(country,page)

    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        TODO("Not yet implemented")
    }
}