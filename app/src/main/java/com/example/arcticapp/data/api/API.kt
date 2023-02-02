package com.example.arcticapp.data.api

import com.example.arcticapp.Extensions.Companion.serializeToMap
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

        suspend fun getWordsList(filter: String): QuerySnapshot? {
            return if (filter == "All"){
                FirebaseFirestore.getInstance().collection("Words").get().await()
            }else{
                FirebaseFirestore.getInstance().collection("Words")
                    .whereEqualTo("category", filter).get().await()
            }
        }

        suspend fun getLessonTheory(lessonID: String): LessonTheory? =
            LessonTheory(
                "",
                hashMapOf(),
                "Скиньте 100 рублей",
                arrayListOf()
            )

        suspend fun getWordInfo(originalWord: String): WordModel? =
            WordModel(
                "мэнду",
                "привет",
                "",
                "слово приветствия",
                ""
            )

        fun getPracticeList(lessonID: String): ArrayList<PracticeTask> =
            arrayListOf(
                PracticeTask(TaskAdapter.TASK_COMPARE,
                    CompareTask(
                        arrayListOf(
                            CompareWord("слово на энецком", "привет"),
                            CompareWord("слово на энецком2", "пока")
                        ),
                        arrayListOf("привет", "пока")
                    ).serializeToMap() as HashMap<Any, Any>
                )
            )

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
                        "афигеть рыжий кот",
                        "хуй пизда сперма пирожки",
                        arrayListOf("сперма", "пизда", "пирожки", "хуй")
                    )
                )
            )

        // TODO: нормальная работа с бд
//            FirebaseFirestore.getInstance().collection("Words")
//                .document(originalWord).get().await()
    }
}