package com.example.kotlincoroutines.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.adapter.NewsAdapter
import com.example.kotlincoroutines.model.Article
import com.example.kotlincoroutines.network.MyApi
import com.example.kotlincoroutines.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val adapter = NewsAdapter()
    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        recyclerviewID.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.news.observe(this,{
            adapter.setData(it?.articles!!)
            recyclerviewID.adapter = adapter
        })

    }
}