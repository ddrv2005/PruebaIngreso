package com.example.prueba.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.prueba.adapters.PostAdapter
import com.example.prueba.databinding.ActivityUserDetailsBinding
import com.example.prueba.models.User
import com.example.prueba.viewmodels.PostViewModels

class UserDetailsActivity : AppCompatActivity() {

    private val postAdapter = PostAdapter {
    }

    private lateinit var binding: ActivityUserDetailsBinding
    private val postViewModel: PostViewModels by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        intent.getParcelableExtra<User>("user")?.let {
            binding.textName.text = it.name
            binding.textPhone.text = it.phone
            binding.textEmail.text = it.email
            observeChanges()
            postViewModel.getPosts(it.id)
        }
     }

    private fun setupRecyclerView() {
        binding.recyclerPost.adapter = postAdapter
    }

    private fun observeChanges() {
        postViewModel.postLiveData.observe(this) {
            postAdapter.setItems(it)
        }
    }

}
