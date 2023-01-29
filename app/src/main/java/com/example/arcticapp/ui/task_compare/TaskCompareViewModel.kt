package com.example.arcticapp.ui.task_compare

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.CompareTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskCompareViewModel: ViewModel() {
    val task: MutableLiveData<CompareTask> = MutableLiveData()

    fun loadTask(taskPath: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getTask("")
            task.postValue(result)
        }
    }
}