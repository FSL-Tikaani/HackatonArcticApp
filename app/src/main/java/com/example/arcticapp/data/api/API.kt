package com.example.arcticapp.data.api

import com.example.arcticapp.data.models.WordModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await

class API {
    companion object{
        suspend fun getWordsList(filter: String): QuerySnapshot? {
            return if (filter == "All"){
                FirebaseFirestore.getInstance().collection("Words").get().await()
            }else{
                FirebaseFirestore.getInstance().collection("Words")
                    .whereEqualTo("category", filter).get().await()
            }
        }

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