package com.example.arcticapp.data.api.savefile

import androidx.room.*
import com.example.arcticapp.data.models.TaskResult

@Dao
interface SavefileDao {
    @Query("SELECT * FROM taskresult")
    fun getAllResults(): List<TaskResult>

    @Query("SELECT * FROM taskresult WHERE taskID = :taskID")
    fun getTaskResultByTaskID(taskID: String): TaskResult?

    @Query("SELECT * FROM taskresult WHERE taskID LIKE :lessonID")
    fun getTaskResultsByLessonID(lessonID: String): List<TaskResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(result: TaskResult): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(result: TaskResult): Int

    @Transaction
    suspend fun upsert(result: TaskResult): Long {
        var id = insert(result)
        if (id == -1L) {
            id = update(result).toLong()
        }
        return id
    }

    @Delete
    suspend fun delete(result: TaskResult)
}