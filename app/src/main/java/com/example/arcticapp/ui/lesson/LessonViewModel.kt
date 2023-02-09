package com.example.arcticapp.ui.lesson

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.EducationItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LessonViewModel: ViewModel() {
    val lessonInfo: MutableLiveData<EducationItemModel> = MutableLiveData()

    fun loadLessonInfo(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getLessonTheory(lessonID)
            lessonInfo.postValue(result)
        }
    }
}