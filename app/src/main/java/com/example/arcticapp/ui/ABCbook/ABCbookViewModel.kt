package com.example.arcticapp.ui.ABCbook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.LetterModel


class ABCbookViewModel : ViewModel() {
    val letters: MutableLiveData<ArrayList<LetterModel>> = MutableLiveData()

    init {
        getLetters()
    }

    private fun getLetters(){
        val data = API.getLetters()
        letters.value = data
    }
}