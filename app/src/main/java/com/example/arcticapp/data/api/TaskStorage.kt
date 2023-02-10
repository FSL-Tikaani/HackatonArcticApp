package com.example.arcticapp.data.api

import com.example.arcticapp.data.models.*
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticappfinal.R

class TaskStorage {
    companion object {
        val lessons = arrayListOf(
            EducationItemModel("lesson1", "Урок 1: первые шаги в энецкий язык", "В этом уроке вы научитесь здороваться, прощатся, знакомится, считать от 1 до 10, а такжеузнаете о указательных и личных местоимениях", R.drawable.education_item_img, 3,
                "video1.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/lesson1%20(1).mp4?alt=media&token=61510d1b-bf24-40c7-bbd8-164f48dc7770"),
            EducationItemModel("lesson2", "Урок 2: семья и занятия", "В этом уроке вы познокомитесь со словами по теме семья и чем занимаются люди в тундре", R.drawable.education_item_img, 2,
                "video2.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/lesson2%20(1).mp4?alt=media&token=0b090900-6d1e-4058-92ec-6260f5af6012"),
            EducationItemModel("lesson3", "Урок 3: все чем-то заняты", "В этом уроке вы познакомитесь с глаголами отдыхать, спать, есть", R.drawable.education_item_img, 0,
                "video3.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"),
            EducationItemModel("lesson4", "Урок 4: все чем-то заняты", "В этом уроке вы изучите слова на тему \"Еда и продукты\", научитесь гворить о своих вкусовых предпочтениях, а также считать от 11 до 20", R.drawable.education_item_img, 0,
                "video4.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/lesson4%20(1).mp4?alt=media&token=fb66255d-9709-4fa9-9137-ab438f696c02"),
            EducationItemModel("lesson5", "Урок 5: в магазине", "В этом уроке вы познакомитесь с энецким алфавитом и познакомитесь со словаме по теме \"Магазин\"", R.drawable.education_item_img, 0,
                "video5.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/lesson5%20(1).mp4?alt=media&token=94445fd7-7f97-42b4-b60d-eec0041f9c03"),
            EducationItemModel("lesson6", "Урок 6: в населённом пункте", "В этом уроке вы познокомитесь со словами по теме семья и чем занимаются люди в тундре", R.drawable.education_item_img, 2,
                "video6.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"),
            EducationItemModel("lesson7", "Урок 7: образование и учёба", "Описание к первому уроку", R.drawable.education_item_img, 0,
                "video7.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"),
            EducationItemModel("lesson8", "Урок 8: здоровье", "Описание к первому уроку", R.drawable.education_item_img, 0,
                "video8.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"),
            EducationItemModel("lesson9", "Урок 9: такие разные вопросы", "Описание к первому уроку", R.drawable.education_item_img, 0,
                "video9.mp4", "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"),
        )

        val lessonTasks = hashMapOf(
            "lesson1" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson1_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson1_2"),
            ),
            "lesson2" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson2_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson2_2"),
                PracticeTask(TaskAdapter.TASK_SENTENCE, "lesson2_3")
            ),
            "lesson3" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson3_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson3_2"),
            ),
            "lesson4" to arrayListOf(
                PracticeTask(TaskAdapter.TASK_TEST, "lesson4_1"),
                PracticeTask(TaskAdapter.TASK_COMPARE, "lesson4_2"),
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
                        "Выберите верный перевод слова \"он\"",
                        arrayListOf("Модь", "Уу”", "Буу”"),
                        2
                    )
                )
            ),

            "lesson3_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Что означает фраза \"ԑбай тоши кауңа\"?",
                        arrayListOf("Спасибо", "Пожалуйста", "Молодец"),
                        0
                    ),
                    TestItem(
                        "Как переводится фраза \"уу” кодид\"",
                        arrayListOf("Я сплю", "Ты спишь", "Он спит"),
                        1
                    ),
                    TestItem(
                        "Как переводится фраза \"буу” коди\"",
                        arrayListOf("Я сплю", "Ты спишь", "Он спит"),
                        2
                    )
                )
            ),

            "lesson2_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Как дословно переводится энецкое слово \"мяз тԑр\"?",
                        arrayListOf("Люди в доме", "Семья","Содержимое чума"),
                        2
                    ),
                    TestItem(
                        "Чем занимаются дети в школе?",
                        arrayListOf("Паздуна”", "Паздучь", "Мосра”", "Мозрашь"),
                        0
                    ),
                    TestItem(
                        "Чем занимаюся родители?",
                        arrayListOf("Паздуна”", "Паздучь", "Мосра”", "Мозрашь"),
                        2
                    )
                )
            ),

            "lesson4_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Й в конце обозначает...",
                        arrayListOf("Притяжательность", "Множественное число", "Инфинитив"),
                        0
                    ),
                    TestItem(
                        "Какая приставка используется для образования числительных от 11 до 19?",
                        arrayListOf("Бикоз", "Бозат", "Бикоз бозат"),
                        2
                    ),
                    TestItem(
                        "Что обозначает уселение гортанного звука?",
                        arrayListOf("Притяжательность", "Множественное число", "Инфинитив"),
                        1
                    )
                )
            ),

            "lesson5_1" to TestTask(
                arrayListOf(
                    TestItem(
                        "Сколько букв в энецком алфавите?",
                        arrayListOf("27", "33", "37"),
                        2
                    ),
                    TestItem(
                        "Сколько специфичных звуков есть в энецком алфавите?",
                        arrayListOf("2", "4", "Нет"),
                        1
                    ),
                    TestItem(
                        "Выберите верный перевод слова он",
                        arrayListOf("Мôдь", "Уу”", "Буу”"),
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
                    CompareWord("Дисы", "Дед"),
                    CompareWord("Каза", "Бабушка"),
                    CompareWord("Чизԑйчу", "Дядя"),
                    CompareWord("Ԑяйчу", "Тётя")
                ),
                arrayListOf("Тётя","Дед","Бабушка","Дядя")
            ),

            "lesson3_2" to CompareTask(
                arrayListOf(
                    CompareWord("кодишь", "спать"),
                    CompareWord("нытагушь", "отдыхать"),
                    CompareWord("ôôдь", "есть"),
                ),
                arrayListOf("отдыхать","спать","есть")
            ),

            "lesson4_2" to CompareTask(
                arrayListOf(
                    CompareWord("озы", "ягода"),
                    CompareWord("буй", "бульон"),
                    CompareWord("кари", "рыба"),
                    CompareWord("кирба", "хлеб"),
                    CompareWord("оса", "мясо")
                ),
                arrayListOf("рыба","ягода", "мясо", "хлеб", "бульон")
            ),

            "lesson5_2" to CompareTask(
                arrayListOf(
                    CompareWord("лапка", "магазин"),
                    CompareWord("конфетка", "конфета"),
                    CompareWord("дю", "масло"),
                    CompareWord("пасиба", "спасибо")
                ),
                arrayListOf("спасибо","масло", "магазин", "конфета")
            ),

            "lesson2_3" to SentenceTask(
                arrayListOf(
                    SentenceItem(
                        "В нашей семье три человека",
                        "мôдьна” мяна” тԑр нэху” энчи”",
                        arrayListOf(SentenceWord("мяна”"), SentenceWord("энчи”"), SentenceWord("мôдьна”"), SentenceWord("нэху”"), SentenceWord("тԑр"))
                    ),
                    SentenceItem(
                        "У меня один брат",
                        "мôдь ңôлю каса касай”",
                        arrayListOf(SentenceWord("каса"), SentenceWord("касай”"), SentenceWord("мôдь"), SentenceWord("ңôлю"))
                    ),
                    SentenceItem(
                        "Мой отец оленевод",
                        "мôдь ԑсый” тэ понида",
                        arrayListOf(SentenceWord("тэ"), SentenceWord("мôдь"), SentenceWord("ԑсый”"), SentenceWord("понида"))
                    ),
                )
            ),

            "lesson5_3" to SentenceTask(
                arrayListOf(
                    SentenceItem(
                        "У вас есть магазин?",
                        "ууда” лапка тонээ",
                        arrayListOf(SentenceWord("тонээ"), SentenceWord("ууда”"), SentenceWord("лапка"))
                    ),
                    SentenceItem(
                        "Магазин сейчас открыт?",
                        "лапка тэза” нԑԑ",
                        arrayListOf(SentenceWord("тэза”"), SentenceWord("нԑԑ"), SentenceWord("лапка"))
                    ),
                    SentenceItem(
                        "Я хочу купить хлеба",
                        "мôдь кирба тыдымад комаз”",
                        arrayListOf(SentenceWord("кирба"), SentenceWord("мôдь"), SentenceWord("тыдымад"), SentenceWord("комаз”"))
                    ),
                )
            )
        )
    }
}