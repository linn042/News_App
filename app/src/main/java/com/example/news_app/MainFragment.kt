package com.example.news_app

import DataLoaderViewModelFactory
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import network.*
import com.example.news_app.repository.DataLoaderViewModel
import com.example.news_app.repository.NewsRepo
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import com.example.news_app.databinding.FragmentMainBinding
import com.example.news_app.network.NewsAdapter


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: NewsAdapter
    private val viewModel: DataLoaderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsAdapter(emptyList())
        binding.newsRecyclerView.adapter = adapter

        viewModel.newsLiveData.observe(viewLifecycleOwner, { newsList ->
            adapter.updateNewsList(newsList)
        })
    }
}

