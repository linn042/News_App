package com.example.news_app.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.R
import com.squareup.picasso.Picasso
import network.ArticleResponse
import com.example.news_app.network.ApiConstants



class NewsAdapter(private val newsList: List<ArticleResponse>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsTitle: TextView = itemView.findViewById(R.id.news_title)
        val newsDescription: TextView = itemView.findViewById(R.id.news_description)
        val newsImage: ImageView = itemView.findViewById(R.id.news_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = newsList[position]

        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description
        Picasso.get().load(article.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
