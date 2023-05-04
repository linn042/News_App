package com.example.news_app.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.news_app.network.NewsApiService
import network.ArticleResponse
import network.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import com.example.news_app.network.ApiConstants

class NewsRepo(private val newsApiService: NewsApiService) {

    suspend fun fetchNews(country: String): List<ArticleResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = newsApiService.fetchNews(country, ApiConstants.API_KEY)
                if (response.isSuccessful) {
                    response.body()?.articles ?: emptyList()
                } else {
                    emptyList()
                }
            } catch (e: HttpException) {
                emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }



    interface NewsCallback {
        fun onSuccess(newsArticles: List<ArticleResponse>)
        fun onError(errorMessage: String)
    }
}

