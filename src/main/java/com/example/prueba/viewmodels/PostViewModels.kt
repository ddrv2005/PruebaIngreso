package com.example.prueba.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.models.PostsResponse
import com.example.prueba.repositories.PostRepository
import kotlinx.coroutines.launch

class PostViewModels: ViewModel() {
    private val postRepository = PostRepository()

    private val _postLiveData: MutableLiveData<PostsResponse> = MutableLiveData()
    val postLiveData: LiveData<PostsResponse> = _postLiveData

    fun getPosts(userId: Int) {
        viewModelScope.launch {
            val response = postRepository.getPost(userId)
            _postLiveData.postValue(response)
        }
    }
}