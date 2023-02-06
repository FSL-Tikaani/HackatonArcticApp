package com.example.arcticapp.ui.vocabulary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticapp.data.models.WordModel
import kotlinx.coroutines.launch

class VocabularyViewModel : ViewModel() {

    val liveDataListVocabulary: MutableLiveData<ArrayList<WordModel>> = MutableLiveData()

    init {
        searchByName("All")
    }

    fun searchByName(filter: String){
        viewModelScope.launch {
            val result = API.getWordsList(filter)

            liveDataListVocabulary.value = result
        }
    }

}