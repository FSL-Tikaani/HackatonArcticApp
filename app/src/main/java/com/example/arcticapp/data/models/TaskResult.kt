package com.example.arcticapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskResult(
    @PrimaryKey
    @ColumnInfo(name = "taskID") val taskID: String,
    @ColumnInfo(name = "result") val result: Int?,
)
