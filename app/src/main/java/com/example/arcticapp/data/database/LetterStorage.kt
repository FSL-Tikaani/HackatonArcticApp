package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.LetterModel
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.R

class LetterStorage {
    companion object {
        val letters: ArrayList<LetterModel> = arrayListOf(
            LetterModel("Аа", WordModel("Аму", "Ладонь", "Аму"), R.drawable.l1),
            LetterModel("Бб", WordModel("Би”", "Вода", "Би"), R.drawable.l2),
            LetterModel("Вв", WordModel("Дорова ңай”", "Здравствуйте", "Дорова най"), R.drawable.l3),
            LetterModel("Гг", WordModel("Дя баг", "Берлога", "дя баг"), R.drawable.l4),
            LetterModel("Дд", WordModel("Дёгураа", "Забор", "Дёгура"), R.drawable.l5),
            LetterModel("Ее", WordModel("Дери", "День", "Дери"), R.drawable.l6),
            LetterModel("Ԑԑ", WordModel("Ԑчуй”", "Дети", "эчуй"), R.drawable.l7),
            LetterModel("Ёё", WordModel("Дёрима", "Беседа", "Дёрима"), R.drawable.l8),
            LetterModel("Жж", WordModel("Журнал", "Журнал", "Журнал"), R.drawable.l9),
            LetterModel("Зз", WordModel("Ползыда", "Чёрный", "ползыда"), R.drawable.l10),
            LetterModel("Ии", WordModel("Иту", "Волосы", "Иту"), R.drawable.l11),
            LetterModel("Йй", WordModel("Буй", "Бульон", "Буй"), R.drawable.l12),
            LetterModel("Кк", WordModel("Коду", "Сани", "коду"), R.drawable.l13),
            LetterModel("Лл", WordModel("Лэдируй", "Голубика", "лэдируй"), R.drawable.l14),
            LetterModel("Мм", WordModel("Моди", "Плечо", "моди"), R.drawable.l15),
            LetterModel("Нн", WordModel("Нибии", "Паук", "нибии"), R.drawable.l16),
            LetterModel("Ңң", WordModel("Ңузу", "Шест", "нузу"), R.drawable.l17),
            LetterModel("Оо", WordModel("Олаа", "Столовая", "олаа"), R.drawable.l18),
            LetterModel("Ôô", WordModel("Ôôдь камачу", "Аппетит", "оодь камачу"), R.drawable.l19),
            LetterModel("Пп", WordModel("Поштээ", "Шар", "поштээ"), R.drawable.l20),
            LetterModel("Рр", WordModel("Роса", "Русский", "роса"), R.drawable.l21),
            LetterModel("Сс", WordModel("Сыляԑйгу кирба", "Булка", "сыляэйгу кирба"), R.drawable.l22),
            LetterModel("Тт", WordModel("Тузуку", "Гриб", "Тузуку"), R.drawable.l23),
            LetterModel("Уу", WordModel("Уза", "Рука", "уза"), R.drawable.l24),
            LetterModel("Фф", WordModel("Конфетка", "Конфета", "конфетка"), R.drawable.l25),
            LetterModel("Хх", WordModel("Халэу", "Чайка", "халэу"), R.drawable.l26),
            LetterModel("Цц", WordModel("Операция", "Операция", "операция"), R.drawable.l27),
            LetterModel("Чч", WordModel("Чамды", "Лягушка", "чамды"), R.drawable.l28),
            LetterModel("Шш", WordModel("Школа", "Школа", "школа"), R.drawable.l29),
            LetterModel("Щщ", WordModel("Щедашь", "Выполнить", "щедашь"), R.drawable.l30),
            LetterModel("ъ", WordModel("В разработке", " ", ""), R.drawable.l31),
            LetterModel("Ыы", WordModel("Дисы", "Дед", "дисы"), R.drawable.l32),
            LetterModel("ь", WordModel("Мôдь", "Я", "модь"), R.drawable.l33),
            LetterModel("Ээ", WordModel("Нэху”", "Три", "нэху"), R.drawable.l34),
            LetterModel("Юю", WordModel("Леблюку", "Бабочка", "леблюку"), R.drawable.l35),
            LetterModel("Яя", WordModel("Дялдыда", "Серый", "дялдыда"), R.drawable.l36),
            LetterModel("”", WordModel("Ни”", "Икра", "Ни"), R.drawable.l37)
        )
    }
}