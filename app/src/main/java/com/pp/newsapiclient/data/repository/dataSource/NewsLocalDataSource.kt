package com.pp.newsapiclient.data.repository.dataSource

import com.pp.newsapiclient.data.db.ArticleDAO
import com.pp.newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSource(
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