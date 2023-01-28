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
        getDataListFromDatabase()
    }

    private fun getDataListFromDatabase(){
        viewModelScope.launch {
            val dataList = ArrayList<WordModel>()

            val result = API.getWordsList("All")

            for(item in result!!.documents){
                val modelItem = item.toObject(WordModel::class.java)
                dataList.add(modelItem!!)
            }

            liveDataListVocabulary.value = dataList
        }
    }
}