package com.priyam.coolnews.data.repository.dataSource

import com.priyam.coolnews.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines():Response<APIResponse>
}