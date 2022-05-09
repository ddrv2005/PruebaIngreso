package com.example.prueba.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.example.prueba.database.App
import com.example.prueba.adapters.UserAdapter
import com.example.prueba.databinding.ActivityMainBinding
import com.example.prueba.viewmodels.UserViewModel
import com.example.prueba.viewmodels.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private val userAdapter = UserAdapter {
        val intent = Intent(this, UserDetailsActivity::class.java)
        intent.putExtra("user", it)
        startActivity(intent)
    }

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(
            (this.application as App).database.userDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.search.doOnTextChanged { text, start, before, count ->

            userViewModel.searchUser(text.toString())
        }
        setupRecyclerView()
        observeDataChanges()
    }

    private fun setupRecyclerView() {
        binding.recycler.adapter = userAdapter
    }

    private fun observeDataChanges() {
        userViewModel.userLiveData.observe(this) {
            userAdapter.setItems(it)
        }
    }
}