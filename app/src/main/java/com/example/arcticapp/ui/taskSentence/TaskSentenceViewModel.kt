package com.example.arcticapp.ui.taskSentence

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.SentenceTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskSentenceViewModel: ViewModel() {
    val task: MutableLiveData<SentenceTask> = MutableLiveData()
    val score: MutableLiveData<Int> = MutableLiveData(0)

    fun loadTask(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getSentenceTask("")
            task.postValue(result)
        }
    }

    fun initializeScoreCounter() {
        //score.postValue(task.value.)
    }

    fun decreaseScore() {
        score.postValue(score.value?.minus(1))
    }
}