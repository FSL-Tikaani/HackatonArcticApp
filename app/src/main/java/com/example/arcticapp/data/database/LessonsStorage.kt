package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.LessonTheory
import com.example.arcticappfinal.R

class LessonsStorage {
    companion object {
        private val Lessons = arrayListOf(
            LessonTheory("lesson1", "Урок 1", "Описание к 1 уроку"),
            LessonTheory("lesson2", "Урок 2", "Описание к 2 уроку"),
            LessonTheory("lesson3", "Урок 3", "Описание к 3 уроку"),
            LessonTheory("lesson4", "Урок 4", "Описание к 4 уроку")
        )

        fun getLessonById(id: String): LessonTheory? {
            return Lessons.find { it.id == id }
        }
    }
}