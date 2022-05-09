package com.example.prueba.repositories
import com.example.prueba.models.PostsResponse
import com.example.prueba.network.ApiConnection

class PostRepository {
    private val apiConnection = ApiConnection.retrofit

    suspend fun getPost(userId: Int): PostsResponse {
        return apiConnection.getPosts(userId = userId)
    }
}