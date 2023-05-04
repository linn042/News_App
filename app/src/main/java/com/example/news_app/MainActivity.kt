package com.example.news_app

import DataLoaderViewModelFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.databinding.ActivityMainBinding
import com.example.news_app.network.NewsAdapter
import com.example.news_app.repository.DataLoaderViewModel
import com.example.news_app.repository.NewsRepo


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewModel: DataLoaderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()

        binding.searchButton.setOnClickListener {
            viewModel.loadNews(binding.searchEditText.text.toString())
        }

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, DataLoaderViewModelFactory(NewsRepo())).get(
            DataLoaderViewModel::class.java)

        viewModel.news.observe(this, Observer {
            newsAdapter.updateNewsList(it)
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.newsRecyclerView.adapter = newsAdapter
    }
}
