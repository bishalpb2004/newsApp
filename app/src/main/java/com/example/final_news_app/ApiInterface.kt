package com.example.final_news_app

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("top-headlines?country=us&category=business&apiKey=6e21932766ab4e558347925d132963f8")
    fun getArticleData():Call<MyData>

}