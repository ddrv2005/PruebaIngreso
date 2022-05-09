package com.example.prueba.models
import com.google.gson.annotations.SerializedName


class PostsResponse : ArrayList<Post>()

data class Post(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)