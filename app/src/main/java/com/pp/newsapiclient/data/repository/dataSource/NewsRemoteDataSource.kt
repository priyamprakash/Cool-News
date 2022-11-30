package com.pp.newsapiclient.data.repository.dataSource

import com.pp.newsapiclient.data.api.NewsAPIService
import com.pp.newsapiclient.data.model.APIResponse
import retrofit2.Response

class NewsRemoteDataSource(
        private val newsAPIService: NewsAPIService
) {
    suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
          return newsAPIService.getTopHeadlines(country,page)
    }

    suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(country,searchQuery,page)
    }
}