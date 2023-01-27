package com.example.arcticapp.ui.wordDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.WordModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordDetailViewModel: ViewModel() {
    val wordInfo: MutableLiveData<WordModel> = MutableLiveData()

    fun loadWord(originalWord: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getWordInfo(originalWord)
            result?.let { word ->
                wordInfo.postValue(word)
            }
        }
    }
}