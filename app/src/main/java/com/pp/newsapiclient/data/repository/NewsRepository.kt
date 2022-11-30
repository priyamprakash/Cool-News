package com.pp.newsapiclient.data.repository

import com.pp.newsapiclient.data.api.NewsAPIService
import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.model.APIResponse
import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import com.pp.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import com.pp.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepository(
    private val newsAPIService: NewsAPIService,
    private val articleDAO: ArticleDAO,
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) {
    suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsAPIService.getTopHeadlines(country,page))
    }

    suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsAPIService.getSearchedTopHeadlines(country,searchQuery,page)
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
        articleDAO.insert(article)
    }

    suspend fun deleteNews(article: Article) {
        articleDAO.deleteArticle(article)
    }

    fun getSavedNews(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }
}