package com.example.arcticapp.ui.achievements

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.API.Companion.getLessonResults
import com.example.arcticapp.data.api.API.Companion.getLessonTheory
import com.example.arcticapp.data.api.TaskStorage
import com.example.arcticapp.data.models.AchievementItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AchievementsViewModel : ViewModel() {
    val progress: MutableLiveData<ArrayList<AchievementItem>> = MutableLiveData()

    init {
        loadProgress()
    }

    private fun loadProgress() {
        viewModelScope.launch(Dispatchers.IO) {
            val progressData = arrayListOf<AchievementItem>()
            TaskStorage.workingLessons.forEach { lessonID ->
                progressData.add(loadLessonProgress(lessonID))
            }
            progress.postValue(progressData)
        }
    }

    private suspend fun loadLessonProgress(lessonID: String): AchievementItem =
        AchievementItem(
            getLessonTheory(lessonID).name,
            getLessonResults(lessonID)
        )
}