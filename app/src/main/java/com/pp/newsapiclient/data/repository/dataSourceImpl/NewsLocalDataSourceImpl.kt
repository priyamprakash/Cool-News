package com.pp.newsapiclient.data.repository.dataSourceImpl

import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.model.Article
import com.pp.newsapiclient.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
)  {
    suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }

    suspend fun deleteArticlesFromDB(article: Article) {
        articleDAO.deleteArticle(article)
    }
}