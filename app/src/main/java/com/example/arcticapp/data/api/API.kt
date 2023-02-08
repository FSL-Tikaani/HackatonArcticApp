package com.example.arcticapp.data.api

import com.example.arcticapp.Extensions.Companion.serializeToMap
import com.example.arcticapp.data.database.DictionaryStorage
import com.example.arcticapp.data.database.LessonsStorage
import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
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

        fun getLessonTheory(lessonID: String): LessonTheory =
            LessonsStorage.getLessonById(lessonID)!!

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

        // Этот метод не нужно исправлять, он тестовый
        fun getTask(lessonID: String): CompareTask =
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

        fun getTestTask(taskID: String) =
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

        // TODO: нормальная работа с бд
//            FirebaseFirestore.getInstance().collection("Words")
//                .document(originalWord).get().await()
    }
}