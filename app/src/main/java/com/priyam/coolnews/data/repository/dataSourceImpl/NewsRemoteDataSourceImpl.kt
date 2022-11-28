package com.priyam.coolnews.data.repository.dataSourceImpl

import com.priyam.coolnews.data.api.NewsApiService
import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,
    private val country: String ,
    private val page:Int

):NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsApiService.getTopHeadlines(country,page)

    }
}