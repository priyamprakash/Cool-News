package com.priyam.coolnews.data.repository

import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.repository.dataSource.NewsRemoteDataSource
import com.priyam.coolnews.data.util.Resource
import com.priyam.coolnews.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {
    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines())
    }

    private fun responseToResource(response: Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful)
        {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }


}