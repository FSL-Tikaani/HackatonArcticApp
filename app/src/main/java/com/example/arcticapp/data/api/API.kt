package com.example.arcticapp.data.api

import com.example.arcticapp.App
import com.example.arcticapp.data.database.DictionaryStorage
import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticappfinal.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class API {
    companion object{
        suspend fun getEducationItems(): DataSnapshot? {
            return FirebaseDatabase.getInstance().getReference("lessons").get().await()
        }

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
                "слово приветствия",
                ""
            )

        fun getLessonList(): ArrayList<EducationItemModel> =
            TaskStorage.lessons

        fun getPracticeList(lessonID: String): ArrayList<PracticeTask> =
            TaskStorage.lessonTasks[lessonID]!!

        fun getTaskByID(taskID: String): Any =
            TaskStorage.tasks[taskID]!!

        // Этот метод не нужно исправлять, он тестовый
        fun getCompareTask(lessonID: String): CompareTask =
            CompareTask(
                arrayListOf(
                    CompareWord("Уу'' нил обу", "Как твое имя?"),
                    CompareWord("Модь ним", "Меня зовут"),
                    CompareWord("Дорова най''", "Здравствуйте"),
                    CompareWord("Локичу най", "До свидания")
                ),
                arrayListOf("Как твое имя?", "Меня зовут", "Здравствуйте", "До свидания")
            )

        fun getSentenceTask(lessonID: String): SentenceTask =
            SentenceTask(
                arrayListOf(
                    SentenceItem(
                        "Здесь будет предложение на русском",
                        "2 1 3 4",
                        arrayListOf("1", "2", "3", "4")
                    ),
                    SentenceItem(
                        "Здесь будет предложение на русском",
                        "Правильное предложение",
                        arrayListOf("слово1", "слово2", "слово3", "слово4")
                    ),
                )
            )

        fun getTestTask(taskID: String): TestTask =
            TestTask(
                arrayListOf(
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    ),
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    ),
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    )
                )
            )

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
    }
}