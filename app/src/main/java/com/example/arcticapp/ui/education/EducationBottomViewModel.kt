package com.example.arcticapp.ui.education

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.LessonResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EducationBottomViewModel: ViewModel() {
    val lessonResults: MutableLiveData<LessonResults> = MutableLiveData()

    fun loadLessonStatistics(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            lessonResults.postValue(API.getLessonResults(lessonID))
        }
    }
}