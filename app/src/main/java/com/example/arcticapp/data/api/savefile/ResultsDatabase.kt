package com.example.arcticapp.data.api.savefile

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.arcticapp.data.models.TaskResult

@Database(entities = [TaskResult::class], version = 1, exportSchema = false)
abstract class ResultsDatabase : RoomDatabase() {
    abstract fun savefileDao(): SavefileDao
}