package com.example.arcticapp.data.models

data class LessonTheory (
    val video: String,
    val videoTimestamps: HashMap<Any, Any>,
    val description: String,
    val words: ArrayList<String>
)