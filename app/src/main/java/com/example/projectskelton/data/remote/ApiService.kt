package com.example.projectskelton.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {

    @GET("categories")
    suspend fun getJokeCategories(): ResponseBody

}