package com.example.kotlincoroutines.network

import com.example.kotlincoroutines.model.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("everything?q=bitcoin&apiKey=c6b66ad2d4fd4cafb451ee8292e1ba25")
    suspend fun getNewsList() : Response<NewsResponse>

   /* @GET("everything?q=bitcoin&apiKey=c6b66ad2d4fd4cafb451ee8292e1ba25")
    fun getNewsList() : Call<NewsResponse>*/

    companion object{
        operator fun invoke() : MyApi{

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }

            val intercepter = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .client(intercepter)
                .build()
                .create(MyApi::class.java)

        }
    }
}