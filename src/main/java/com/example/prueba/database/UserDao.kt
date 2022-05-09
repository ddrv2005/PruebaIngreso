package com.example.prueba.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers() : List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE name LIKE '%' || :text || '%'")
    fun searchUsers(text: String) : List<User>
}