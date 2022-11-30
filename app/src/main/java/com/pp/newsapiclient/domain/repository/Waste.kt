package com.pp.newsapiclient.domain.repository

import com.pp.newsapiclient.data.model.APIResponse
import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface Waste{

      suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse>
      suspend fun getSearchedNews(country: String,searchQuery:String,page: Int) : Resource<APIResponse>
      suspend fun saveNews(article: Article)
      suspend fun deleteNews(article: Article)
      fun getSavedNews(): Flow<List<Article>>




}