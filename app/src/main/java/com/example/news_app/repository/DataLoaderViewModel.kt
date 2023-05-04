package com.example.news_app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import network.NewsResponse

class DataLoaderViewModel(private val newsRepo: NewsRepo) : ViewModel() {
    private val _newsData = MutableLiveData<NewsResponse>()
    val newsData: LiveData<NewsResponse> = _newsData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun loadNews(country: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val articleResponse = newsRepo.fetchNews(country)
                _newsData.value = NewsResponse("ok", articleResponse.size, articleResponse)
                _loading.value = false
            } catch (e: Exception) {
                // handle error
                _loading.value = false
            }
        }
    }
}
