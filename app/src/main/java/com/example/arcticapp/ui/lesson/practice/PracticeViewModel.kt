package com.example.arcticapp.ui.lesson.practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.PracticeTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PracticeViewModel : ViewModel() {
    val practiceList: MutableLiveData<ArrayList<PracticeTask>> = MutableLiveData()

    fun loadPracticeList(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getPracticeList(lessonID)
            practiceList.postValue(result)
        }
    }
}