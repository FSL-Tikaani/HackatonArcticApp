package com.example.arcticapp.ui.congratulations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.TaskResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CongratulationsViewModel: ViewModel() {

    fun addTaskResultToDatabase(taskResult: TaskResult) {
        viewModelScope.launch(Dispatchers.IO) {
            API.uploadTaskResult(taskResult)
        }
    }
}