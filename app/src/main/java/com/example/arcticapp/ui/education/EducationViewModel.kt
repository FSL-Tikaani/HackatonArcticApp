package com.example.arcticapp.ui.education

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticapp.data.models.WordModel
import kotlinx.coroutines.launch

class EducationViewModel : ViewModel() {

    val liveDataListItemsEducation: MutableLiveData<ArrayList<EducationItemModel>> = MutableLiveData()

    init {
        getDataListFromDatabase()
    }

    private fun getDataListFromDatabase(){
        viewModelScope.launch {
            liveDataListItemsEducation.postValue(API.getLessonList())
        }
    }
}