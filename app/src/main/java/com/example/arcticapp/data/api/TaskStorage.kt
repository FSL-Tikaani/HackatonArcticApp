package com.example.arcticapp.data.api

import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticappfinal.R

class TaskStorage {
    companion object {
        val lessons = arrayListOf(
            EducationItemModel(
                "Урок 1 первые шаги",
                "В этом уроке вы познакомитесь с энецким, имена фамилии узнаете, еще счиатть научитесь и тд",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson1",
                3
            ),
            EducationItemModel(
                "Урок 1 первые шаги",
                "В этом уроке вы познакомитесь с энецким, имена фамилии узнаете, еще счиатть научитесь и тд",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson2",
                3
            ),
            EducationItemModel(
                "Урок 1 первые шаги",
                "В этом уроке вы познакомитесь с энецким, имена фамилии узнаете, еще счиатть научитесь и тд",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson3",
                3
            )
        )

        val lessonTasks = hashMapOf(
            "lesson1" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson1_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson1_2"),
                PracticeTask(TaskAdapter.TASK_SENTENCE, "lesson1_3")
            ),
            "lesson2" to arrayListOf(
            ),
            "lesson3" to arrayListOf(
            ),
            "lesson4" to arrayListOf(
            )
        )

        val tasks = hashMapOf(
            "lesson1_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    ),
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    ),
                    TestItem(
                        "Как какать?",
                        arrayListOf("Никак", "Легко", "Сложно"),
                        0
                    )
                )
            ),

            "lesson1_2" to CompareTask(
                arrayListOf(
                    CompareWord("Уу'' нил обу", "Как твое имя?"),
                    CompareWord("Модь ним", "Меня зовут"),
                    CompareWord("Дорова най''", "Здравствуйте"),
                    CompareWord("Локичу най", "До свидания")
                ),
                arrayListOf("Как твое имя?", "Меня зовут", "Здравствуйте", "До свидания")
            ),

            "lesson1_3" to SentenceTask(
                arrayListOf(
                    SentenceItem(
                        "Здесь будет предложение на русском",
                        "2 1 3 4",
                        arrayListOf("1", "2", "3", "4")
                    ),
                    SentenceItem(
                        "Здесь будет предложение на русском",
                        "Правильное предложение",
                        arrayListOf("слово1", "слово2", "слово3", "слово4")
                    ),
                )
            )

        )
    }
}