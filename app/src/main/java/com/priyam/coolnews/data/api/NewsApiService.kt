package com.priyam.coolnews.data.api

import androidx.core.os.BuildCompat
import com.priyam.coolnews.data.model.APIResponse
import com.priyam.coolnews.data.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = Constants.key
    ): Response<APIResponse>

    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadlines(
        @Query("country")
        country:String,
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = Constants.key
    ): Response<APIResponse>
}