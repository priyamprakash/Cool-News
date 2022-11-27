package com.priyam.coolnews.domain.repository

import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.util.Resource

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
}