package com.example.arcticapp.ui.taskTest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.TestTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskTestViewModel: ViewModel() {
    val task: MutableLiveData<TestTask> = MutableLiveData()

    fun loadTask(taskID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getTestTask(taskID)
            task.postValue(result)
        }
    }
}