package com.example.arcticapp

import android.app.Application
import androidx.room.Room
import com.example.arcticapp.data.api.savefile.ResultsDatabase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        resultsDatabase = Room.databaseBuilder(
            applicationContext, ResultsDatabase::class.java,
            RESULT_DATABASE
        ).build()
    }

    companion object {
        lateinit var instance: App
            private set

        lateinit var resultsDatabase: ResultsDatabase
            private set

        const val RESULT_DATABASE = "results"
    }
}