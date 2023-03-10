package com.example.arcticapp.data.api

import com.example.arcticapp.App
import com.example.arcticapp.data.database.DictionaryStorage
import com.example.arcticapp.data.database.LetterStorage
import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter

class API {
    companion object{

        fun getLetters() = LetterStorage.letters

        fun getWordsList(filter: String): ArrayList<WordModel> {
            if (filter == "All"){
                return DictionaryStorage.getAllWords()
            }else{
                return DictionaryStorage.getWordsByName(filter)
            }
        }

        fun getLessonTheory(lessonID: String): EducationItemModel =
            TaskStorage.lessons.find{ it.id == lessonID }!!

        suspend fun getWordInfo(originalWord: String): WordModel? =
            WordModel(
                "мэнду",
                "привет",
                "",
            )

        fun getLessonList(): ArrayList<EducationItemModel> =
            TaskStorage.lessons

        fun getPracticeList(lessonID: String): ArrayList<PracticeTask> =
            TaskStorage.lessonTasks[lessonID]!!

        private fun getTaskByID(taskID: String): Any =
            TaskStorage.tasks[taskID]!!

        // Этот метод не нужно исправлять, он тестовый
        fun getCompareTask(taskID: String): CompareTask =
            getTaskByID(taskID) as CompareTask

        fun getSentenceTask(taskID: String): SentenceTask =
            getTaskByID(taskID) as SentenceTask

        fun getTestTask(taskID: String): TestTask =
            getTaskByID(taskID) as TestTask

        suspend fun uploadTaskResult(taskResult: TaskResult) {
            val previousResult = getTaskResult(taskResult.taskID)
            try {
                if (previousResult!!.result!! >= taskResult.result!!) {
                    return
                } else {
                    saveTaskResult(taskResult)
                }
            } catch (e: java.lang.Exception) {
                saveTaskResult(taskResult)
            }
        }
        private suspend fun saveTaskResult(taskResult: TaskResult) {
            App.resultsDatabase.savefileDao().upsert(taskResult)
        }


        suspend fun getTaskResult(taskID: String): TaskResult? =
            App.resultsDatabase.savefileDao().getTaskResultByTaskID(taskID)

        suspend fun getLessonResults(lessonID: String): LessonResults {
            val lessonTasks = getPracticeList(lessonID)
            var userScore = 0
            var maxScore = 0
            var completedTasks = 0
            lessonTasks.forEach {
                val taskResult = getTaskResult(it.taskID)
                maxScore += when(it.type) {
                    TaskAdapter.TASK_TEST -> getTestTask(it.taskID).tasks.size
                    TaskAdapter.TASK_SENTENCE -> getSentenceTask(it.taskID).sentences.size
                    TaskAdapter.TASK_COMPARE -> getCompareTask(it.taskID).rusWords.size
                    else -> 0
                }
                if (taskResult != null) {
                    userScore += taskResult.result!!
                    completedTasks++
                }
            }

            return LessonResults(completedTasks, lessonTasks.size, userScore, maxScore)
        }

        fun isNotWorking(id: String): Boolean = !TaskStorage.workingLessons.contains(id)
    }
}