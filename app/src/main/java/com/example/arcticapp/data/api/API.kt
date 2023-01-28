package com.example.arcticapp.data.api

import com.example.arcticapp.data.models.LessonTheory
import com.example.arcticapp.data.models.WordModel
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
        // TODO: нормальный подбор слов из базы
//            FirebaseFirestore.getInstance().collection("Words")
//                .document(originalWord).get().await()
    }
}