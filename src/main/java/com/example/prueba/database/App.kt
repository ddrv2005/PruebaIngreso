package com.example.prueba.database

import android.app.Application

class App: Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}