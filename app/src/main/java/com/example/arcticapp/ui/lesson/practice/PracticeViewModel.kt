package com.example.arcticapp.ui.lesson.practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.PracticeTask
import com.example.arcticapp.data.models.TaskItem
import com.example.arcticapp.data.models.TaskResult
import com.example.arcticapp.ui.adapters.TaskAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PracticeViewModel : ViewModel() {
    val practiceList: MutableLiveData<ArrayList<TaskItem>> = MutableLiveData()

    fun loadPracticeList(lessonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = API.getPracticeList(lessonID)
            val taskItems = arrayListOf<TaskItem>()
            result.forEach { practiceTask ->
                var taskResult = API.getTaskResult(practiceTask.taskID)
                if (taskResult == null) {
                    taskResult = TaskResult(practiceTask.taskID, 0)
                }
                val maxScore = when(practiceTask.type) {
                    TaskAdapter.TASK_TEST -> API.getTestTask(practiceTask.taskID).tasks.size
                    TaskAdapter.TASK_COMPARE -> API.getCompareTask(practiceTask.taskID).rusWords.size
                    TaskAdapter.TASK_SENTENCE -> API.getSentenceTask(practiceTask.taskID).sentences.size
                    else -> {0}
                }
                taskItems.add(TaskItem(
                    practiceTask, taskResult.result!!, maxScore
                ))
            }
            practiceList.postValue(taskItems)
        }
    }
}