package com.pp.newsapiclient.data.repository

import com.pp.newsapiclient.data.model.APIResponse
import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import com.pp.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.pp.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepository(
        private val newsRemoteDataSource: NewsRemoteDataSource,
        private val newsLocalDataSource: NewsLocalDataSource
) {
    suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedNews(country,searchQuery,page)
        )
    }

    private fun responseToResource(response:Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
    

    suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}