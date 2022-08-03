package com.example.kotlincoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincoroutines.model.NewsResponse
import com.example.kotlincoroutines.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel :ViewModel() {

    val news : LiveData<NewsResponse?> = MutableLiveData()

    init {
        viewModelScope.launch {
            news as MutableLiveData
           val response = async { callSuspendingFunction() }
            news.value =  response.await()
        }
    }

    private suspend fun callSuspendingFunction() : NewsResponse? {
        return withContext(Dispatchers.IO){
            MyApi.invoke().getNewsList().body()
        }
    }

}