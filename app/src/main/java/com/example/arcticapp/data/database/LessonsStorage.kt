package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.LessonTheory
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.R

class LessonsStorage {
    companion object {
        private val Lessons = arrayListOf(
            LessonTheory("lesson1", "Урок 1", "Описание к 1 уроку",1, arrayListOf(
                WordModel("OriginWord1", "translation", "category", "desc", "1"),
                WordModel("OriginWord2", "translation", "category", "desc", "1"),
                WordModel("OriginWord3", "translation", "category", "desc", "1"))),
            LessonTheory("lesson2", "Урок 2", "Описание к 2 уроку",1, arrayListOf(
                WordModel("OriginWord2", "translation", "category", "desc", "1"))),
            LessonTheory("lesson3", "Урок 3", "Описание к 3 уроку",1, arrayListOf(
                WordModel("OriginWord3", "translation", "category", "desc", "1"))),
            LessonTheory("lesson4", "Урок 4", "Описание к 4 уроку",1, arrayListOf(
                WordModel("OriginWord4", "translation", "category", "desc", "1"))),
            )

        fun getLessonById(id: String): LessonTheory? {
            return Lessons.find { it.id == id }
        }
    }
}