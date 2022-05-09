package com.example.prueba.viewmodels

import androidx.lifecycle.*
import com.example.prueba.database.UserDao
import com.example.prueba.models.User
import com.example.prueba.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(userDao: UserDao): ViewModel() {


    private val userRepository = UserRepository(userDao)

    private val _userLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val userLiveData: LiveData<List<User>> = _userLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUsers()

            userRepository.userFlow.collect {
                _userLiveData.postValue(it)
            }
        }
    }

    fun searchUser(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.searchUser(text)
        }
    }
}

class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}