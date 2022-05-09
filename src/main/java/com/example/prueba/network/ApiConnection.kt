package com.example.prueba.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConnection {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(
            GsonConverterFactory.create())
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()
        .create(Api::class.java)

}