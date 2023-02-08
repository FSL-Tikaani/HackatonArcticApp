package com.example.arcticapp.data.models

import com.example.arcticappfinal.R

data class LessonTheory (
    val id: String = "",
    val nameLesson: String = "defaultName",
    val descriptionLesson: String = "defaultDescription",
    val srcVideo: Int = R.raw.video1,
    val arrWordsInVideo: ArrayList<String> = ArrayList()
)