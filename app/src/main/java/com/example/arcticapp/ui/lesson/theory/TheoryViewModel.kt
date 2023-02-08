package com.example.arcticapp.ui.lesson.theory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.LessonTheory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TheoryViewModel : ViewModel() {
    val theory: MutableLiveData<LessonTheory> = MutableLiveData()

    fun loadTheory(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            theory.postValue(API.getLessonTheory(lessonID))
        }
    }
}