package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.WordModel

class DictionaryStorage {
    companion object {
        private val words = arrayListOf(
            WordModel("name1"),
            WordModel("name2"),
            WordModel("name3"),
            WordModel("name4"),
            WordModel("name5"),
            WordModel("name6"),
            WordModel("name7"),
            WordModel("name8")
        )

        fun getWordsByName(name: String): ArrayList<WordModel> {
            val sortedWords = ArrayList<WordModel>()

            for(i in 0 until words.size){
                if(words[i].originalWord.contains(name) || words[i].translation.contains(name)){
                    sortedWords.add(words[i])
                }
            }
            return sortedWords
        }

        fun getAllWords(): ArrayList<WordModel>{
            return words
        }
    }
}