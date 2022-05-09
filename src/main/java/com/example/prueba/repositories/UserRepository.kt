package com.example.prueba.repositories

import com.example.prueba.database.UserDao
import com.example.prueba.models.User
import com.example.prueba.network.ApiConnection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Exception

class UserRepository(private val userDao: UserDao) {
    private val apiConnection = ApiConnection.retrofit

    private val _userFlow: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val userFlow: StateFlow<List<User>> = _userFlow

    suspend fun getUsers() {
        _userFlow.emit(userDao.getAllUsers())
        try {
            apiConnection.getUser().also {
                userDao.insertAll(it)
                _userFlow.emit(userDao.getAllUsers())
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    suspend fun searchUser(text: String) {
       _userFlow.emit(userDao.searchUsers(text))
    }

}