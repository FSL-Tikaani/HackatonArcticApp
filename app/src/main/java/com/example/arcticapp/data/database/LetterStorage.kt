package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.LetterModel
import com.example.arcticapp.data.models.WordModel

class LetterStorage {
    companion object {
        val letters: ArrayList<LetterModel> = arrayListOf(
            LetterModel("Аа", WordModel("Аму", "Ладонь"), 0),
        )
    }
}