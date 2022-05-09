package com.example.prueba.network

import com.example.prueba.models.PostsResponse
import com.example.prueba.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("users")
    suspend fun getUser(): UserResponse

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId: Int): PostsResponse
}