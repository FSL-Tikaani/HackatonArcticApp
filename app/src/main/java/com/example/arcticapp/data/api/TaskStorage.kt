package com.example.arcticapp.data.api

import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticappfinal.R

class TaskStorage {
    companion object {
        val lessons = arrayListOf(
            EducationItemModel(
                "Урок 1: первые шаги в энецкий язык",
                "В этом уроке вы научитесь здороваться, прощатся, знакомится, считать от 1 до 10, а такжеузнаете о указательных и личных местоимениях",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson1",
                3
            ),
            EducationItemModel(
                "Урок 2: семья и занятия",
                "В этом уроке вы познокомитесь со словами по теме семья и чем занимаются люди в тундре",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson2",
                3
            ),
            EducationItemModel(
                "Урок 3: все чем-то заняты",
                "",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson3",
                3
            ),
            EducationItemModel(
                "Урок 4: еда и продукты",
                "В этом уроке вы изучите слова на тему \"Еда и продукты\", научитесь гворить о своих вкусовых предпочтениях, а также считать от 11 до 20",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson4",
                3
            ),
            EducationItemModel(
                "Урок 5: в магазине",
                "В этом уроке вы познакомитесь с энецким алфавитом и познакомитесь со словаме по теме \"Магазин\"",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson5",
                3
            ),
            EducationItemModel(
                "Урок 6: в населённом пункте",
                "",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson6",
                3
            ),
            EducationItemModel(
                "Урок 7: образование и учёба",
                "",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson7",
                3
            ),
            EducationItemModel(
                "Урок 8: здоровье",
                "",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson8",
                3
            ),
            EducationItemModel(
                "Урок 9: такие разные вопросы",
                "",
                R.drawable.education_item_img,
                R.raw.video1,
                "lesson9",
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
                PracticeTask(TaskAdapter.TASK_TEST, "lesson2_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson2_2"),
                PracticeTask(TaskAdapter.TASK_SENTENCE, "lesson2_3")
            ),
            "lesson4" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson4_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson4_2"),
                PracticeTask(TaskAdapter.TASK_SENTENCE, "lesson4_3")
            ),
            "lesson5" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson5_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson5_2"),
                PracticeTask(TaskAdapter.TASK_SENTENCE, "lesson5_3")
            )
        )

        val tasks = hashMapOf(
            "lesson1_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Есть ли в энецком языке вежливая форма обращения?",
                        arrayListOf("Да", "Нет"),
                        1
                    ),
                    TestItem(
                        "Есть в энецком языке двойственное число?",
                        arrayListOf("Да", "Нет"),
                        0
                    ),
                    TestItem(
                        "Выберите верный перевод слова он",
                        arrayListOf("Модь", "Уу”", "Буу”"),
                        3
                    )
                )
            ),

            "lesson2_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Как дословно переводится энецкое слово \"мяз тԑр\"?",
                        arrayListOf("люди в доме", "семья","содержимое чума"),
                        2
                    ),
                    TestItem(
                        "Есть в энецком языке двойственное число?",
                        arrayListOf("Да", "Нет"),
                        0
                    ),
                    TestItem(
                        "Выберите верный перевод слова он",
                        arrayListOf("Модь", "Уу”", "Буу”"),
                        0
                    )
                )
            ),

            "lesson4_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Есть ли в энецком языке вежливая форма обращения?",
                        arrayListOf("Да", "Нет"),
                        1
                    ),
                    TestItem(
                        "Есть в энецком языке двойственное число?",
                        arrayListOf("Да", "Нет"),
                        0
                    ),
                    TestItem(
                        "Выберите верный перевод слова \"он\"?",
                        arrayListOf("Модь", "Уу”", "Буу”"),
                        0
                    )
                )
            ),

            "lesson5_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Как дословно переводится энецкое слово \"мяз тԑр\"?",
                        arrayListOf("люди в доме", "семья","содержимое чума"),
                        2
                    ),
                    TestItem(
                        "Есть в энецком языке двойственное число?",
                        arrayListOf("Да", "Нет"),
                        0
                    ),
                    TestItem(
                        "Выберите верный перевод слова он",
                        arrayListOf("Модь", "Уу”", "Буу”"),
                        0
                    )
                )
            ),

            "lesson1_2" to CompareTask(
                arrayListOf(
                    CompareWord("Уу” нил обу", "Как твое имя?"),
                    CompareWord("Мôдь ним", "Меня зовут"),
                    CompareWord("Дорова ңай”", "Здравствуйте"),
                    CompareWord("Локичу ңай”", "До свидания")
                ),
                arrayListOf("Меня зовут","До свидания", "Здравствуйте", "Как твое имя?")
            ),

            "lesson2_2" to CompareTask(
                arrayListOf(
                    CompareWord("Мôдьна” мяна” тԑр нэху” энчи”", "В нашей семье три человек"),
                    CompareWord("Мôдь ңôлю каса касай”", "У меня один брат"),
                    CompareWord("Мôдь ԑсый” тэ понида", "Мой отец оленевод"),
                    CompareWord("Ԑԑбь” мôдь мяз понида", "Моя мать чумработница")
                ),
                arrayListOf("У меня один брат","Моя мать чумработница","Мой отец оленевод","В нашей семье три человек")
            ),

            "lesson4_2" to CompareTask(
                arrayListOf(
                    CompareWord("Уу” нил обу", "Как твое имя?"),
                    CompareWord("Мôдь ним", "Меня зовут"),
                    CompareWord("Дорова ңай”", "Здравствуйте"),
                    CompareWord("Локичу ңай”", "До свидания")
                ),
                arrayListOf("Меня зовут","До свидания", "Здравствуйте", "Как твое имя?")
            ),

            "lesson5_2" to CompareTask(
                arrayListOf(
                    CompareWord("Уу” нил обу", "Как твое имя?"),
                    CompareWord("Мôдь ним", "Меня зовут"),
                    CompareWord("Дорова ңай”", "Здравствуйте"),
                    CompareWord("Локичу ңай”", "До свидания")
                ),
                arrayListOf("Меня зовут","До свидания", "Здравствуйте", "Как твое имя?")
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