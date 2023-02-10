package com.example.arcticapp.data.database

import com.example.arcticapp.data.models.WordModel

class DictionaryStorage {
    companion object {
        private val words = arrayListOf(
            WordModel("ңôлю", "один", "нолю"),
            WordModel("Дорова ңай”!", "Здравствуйте! Здравствуй!", "дорова най"),
            WordModel("Уу” нил обу?”","Как тебя зовут?", "у нил обу" ),
            WordModel("Мôдь нимь”...", "Меня зовут...", "модь ним"),
            WordModel("Бу” нида обу?", "Как его зовут?", "бу нида обу"),
            WordModel("Кôкуз уу” тосад?", "Откуда ты приехал?", "кокуз у тосад"),
            WordModel("Кокуз бу” тôса?", "Откуда он(а) приехал(а)?", "кокуз у тоса"),
            WordModel("Щеэд, обу дез уу” тôсад?", "К кому и зачем ты приехал?", "Щеэд обу дез у тосад"),
            WordModel("Ку” уу” нэртасар?", ". Где ты остановился?", "Ку у нэртасар"),
            WordModel("Мôдь” гостиницахан нэртайбичь.", "Я остановился в гостинице", "Модь гостиницахан нэртайбичь"),
            WordModel("Ԑкун уу” кудахаа ԑзад?", "Ты долго пробудешь здесь?", "экун у кудахаа эзад"),
            WordModel("Мôдь мякунь” мяззашь тôнид", "Приходи ко мне в гости", "Модь мякунь мязашь тонид"),
            WordModel("Мят тԑр уу” ага?", "У тебя большая семья?", "Мят тэр у ага"),
            WordModel("Сԑн каса касар (нԑ касар)?", "Сколько у тебя братьев (сестёр)?", "Сэн каса касар нэ касар"),
            WordModel("Каса касар (нԑ касар) кунын мосра?", "Где работает твой брат (твоя сестра)?", "Каса касар нэ касар кунын мосра"),
            WordModel("Ума", "Мама", "ума"),
            WordModel("Ача", "Папа", "ача"),
            WordModel("Ԑԑ", "Мать", "э"),
            WordModel("Ԑсы", "Отец", "эсы"),
            WordModel("Каса каса", "Брат", "каса каса"),
            WordModel("Каса сооку", "Братишка", "каса соку"),
            WordModel("Нԑ каса", "Сестра", "нэ каса"),
            WordModel("Нԑ сооку", "Сестрёнка", "нэ соку"),
            WordModel("Абаа", "Старшая сестра", "аба"),
            WordModel("Инаа", "Старший брат", "ина"),
            WordModel("Ибляйгу каса каса", "Маленький братишка", "Ибляйгу каса каса"),
            WordModel("Ибляйгу нԑ каса", "Маленькая сестрёнка", "Ибляйгу нэ каса"),
            WordModel("Дисы", "Дед", "дисы"),
            WordModel("Каза", "Бабушка", "каза"),
            WordModel("Каки", "Бабуля", "каки"),
            WordModel("Иляа", "Дедуля", "иляа"),
            WordModel("Ԑяйчу", "Тётя", "эяйчу"),
            WordModel("Чизԑйчу", "Дядя", "чизэйчу"),
            WordModel("Уу” дя неон дязудь комитад?", "Ты любишь путешествовать?", "У дя неон дязудь комитад"),
            WordModel("Чу”!", "Войди!", "Чу"),
            WordModel("Камуз ми чу”!", "Войди!", "Камуз ми чу"),
            WordModel("Тôнид (тôнира”)", "Приходи (приезжай)", "Тонид тонира"),
            WordModel("Мяззашь тôнид", "Приходи в гости", "Мяззашь тонид"),
            WordModel("Ань тôнид", "Приходи ещё", "Ань тонид"),
            WordModel("Сояй дери понидь тôнид", "Приходи на день рождения", "Сояй дери понидь тонид"),
            WordModel("Ага дери понидь тôнид", "Приходи на праздник", "Ага дери понидь тонид"),
            WordModel("Мôдь мякунь” канихуй”!", "Пойдём ко мне домой", "Модь мякунь канихуй"),
            WordModel("Пед дязудь канихуй”!", "Пойдём гулять на улицу", "Пед дязудь канихуй"),
            WordModel("Локичу ңай”! ", "До свидания!", "Локичу най"),
            WordModel("Кащинь” модыт небим”!", "До скорой встречи! (Скоро мы с тобой увидимся!)", "Кащинь модыт небим"),
            WordModel("Четай дёдид ңай”!", "До завтра!", "Четай дёдид най"),
            WordModel("Щизза” модычь ԑдыбиз”!", "Рад(а) вас видеть!", "Щиза модычь эдыбиз"),
            WordModel("Дяткуид!", "Пожалуйста! (Просьба)", "Дяткуид"),
            WordModel("Пасиба ңай”!", "Спасибо!", "Пасиба най"),
            WordModel("Похудыра” ңара”!", "Будьте здоровы! ", "Похудыра нара"),
            WordModel("Пухузуд лытбира”!", "Береги себя!", "Пухузуд лытбира"),
            WordModel("Сойза", "Хорошо", "Сойза"),
            WordModel("Торь куньчеэ сойзарха", "Так будет лучше", "Торь куньчеэ сойзарха"),
            WordModel("Чики мôдь сэйхунынь” очикураха", "Мне это не нравится", "Чики модь сэйхунынь очикураха"),
            WordModel("Чики сэйхунынь” сойзарха", "Это мне нравится", "Чики сэйхунынь сойзарха"),
            WordModel("Уу” сэйхуныд чики сойза?", "Тебе это нравится?", "У сэйхуныд чики сойза"),
            WordModel("Торь боа", "Так нельзя", "Торь боа"),
            WordModel("Чики боа", "Это плохо", "Чики боа"),
            WordModel("Кунь уу” тотагуор, бу” сойза энчи”?", "Как ты считаешь, он хороший человек?", "Кунь у тотагуор, бу сойза энчи"),
            WordModel("Уу” нонынь” ңôт мосрашь комад?", "Ты согласен работать со мной в паре?", "У нонынь нот мосрашь комад"),
            WordModel("Дягу, бу” биида у” щер нез” биитур”", "Я с ним не согласен!", "Дягу бу биида у щер нез биитур"),
            WordModel("Сойзаан ôôңара”!", "Приятного аппетита!", "Сойзан онара"),
            WordModel("Уу” тагушь дёдил ôка”?", "У тебя много свободного времени?", "У тагушь дёдил ока"),
            WordModel("Уу” тэза” тагур тонээ?", "Ты свободен сейчас?", "У тэза тагур тонэ"),
            WordModel("Мôдь тагуй” тэза” дягу", "Я сейчас занят", "модь тагуй тэза дягу"),
            WordModel("Мôдь тэза” тагуй” тонээ", "Я сейчас свободен", "одь тэза тагуй тонэ"),
            WordModel("Мôдь тагуушь дёдий” ңуль дягууби", "У меня совсем не бывает свободного времени", "Модь тагушь дёдий нуль дягуби"),
            WordModel("Мôдь тагуушь дёдий” ôка", "У меня свободного времени достаточно", "Модь тагушь дёдий ока"),
            WordModel("Ууда” посёлкахунада” лапка тонээ?", "У вас в посёлке есть магазин?", "уда посёлкахунада лапка тонэ?"),
            WordModel("Лапка тэза” нԑԑ?", "Магазин сейчас открыт?", "Лапка тэза нэ"),
            WordModel("Лапка куна (сԑн часхун) нԑтырадыз”?", "Когда (во сколько) открывается магазин?", "Лапка куна сэн часхун нэтырадыз"),
            WordModel("Обу уу” тыдымад комад?", "Что ты хочешь купить?", "Обу у тыдымад комад"),
            WordModel("Чики обуру мируза сԑн?", "Сколько стоит эта вещь?", "Чики обуру мируза сэн"),
            WordModel("Мôдь тԑхԑ обурузуй” тыдытаз”", "Я куплю себе вон ту вещь", "Модь тэхэ обурузуй тыдытаз"),
            WordModel("Уу” бясыр тоори?", "Тебе хватает денег?", "У бясыр тоори"),
            WordModel("Мôдь бясый” тоори", "Мне хватает денег", "модь бясый тоори"),
            WordModel("Мôдь бясый” ни тоори”", "Мне не хватает денег", "модь бясый ни тоори"),
            WordModel("Ууда” посёлкаханыда” почта тонээ?", "У вас в посёлке есть почта?", "Уда посёлкаханыда почта тонэ"),
            WordModel("Куна почта мосра?", "В какое время работает почта?", "Куна почта мосра"),
            WordModel("Куна почта мосра?", "В какое время работает почта?", "Куна почта мосра"),
            WordModel("Уу” телефонхузуд дёрибунь” сойза?", "Разреши мне, пожалуйста, позвонить с твоего телефона", "Уу” телефонхузуд дёрибунь” сойза?"),
            WordModel("Ңаза ԑки дери курсы?", "Какая сегодня погода?", "наза эки дери курсы?"),
            WordModel("Ңаза ԑки дери сойза (очик)", "Сегодня погода хорошая (плохая)", "наза эки дери сойза очик"),
            WordModel("Ԑки дери пехун сари дяза", "Сегодня на улице идёт дождь", "эки дери пехун сари дяза"),
            WordModel("Ԑки дери пехун казу", "Сегодня на улице пурга", "эки дери пехун казу"),
            WordModel("Ԑки дери тэчи (дюба, депи)", "Сегодня холодно (тепло, жарко)", "эки дери тэчи дюба депи"),
            WordModel("Обу толха ңа уу” комитад?", "Какая погода тебе нравится?", "Обу толха на у комитад"),
            WordModel("Мôдь сойза ңа отыэдаз”", "Я буду ждать хорошей погоды", "Модь сойза на отыэдаз"),
            WordModel("Уу” кадруйдь?", "Ты заболел?", "У кадруйдь"),
            WordModel("Обур деэ?", "Что у тебя болит?", "Обур деэ?"),
            WordModel("Куна уу” кадридь?", "Когда ты заболел?", "Куна у кадридь"),
            WordModel("Чики лякарса од!", "Выпей это лекарство!", "Чики лякарса од"),
            WordModel("Укол щедашь тара", "Надо сделать укол", "Укол щедашь тара"),
            WordModel("Операция щедашь тара", "Надо делать операцию", "Операция щедашь тара"),
            WordModel("Уу” курсыд?", "Как ты себя чувствуешь?", "У курсыд"),
            WordModel("Уу” дезыщид?", "Не болеешь ли ты?", "У дезыщид"),
            WordModel("Уу” больницад базтабут тара", "Тебе надо лечь в больницу", "У больницад базтабут тара"),
            WordModel("Похудыра” ңара”!", "Будьте здоровы!", "Похудыра нара"),
            WordModel("Сԑн час?", "Который час?", "Сэн час"),
            WordModel("Ԑки дери обу число?", "Какое сегодня число?", "эки дери обу число"),
            WordModel("Ԑки сԑу дери” обу дериза?", "Какой сегодня день недели?", "Ԑки сԑу дери” обу дериза?"),
            WordModel("Куна уу” нона” тôзад?", "Когда ты придёшь к нам?", "Куна у нона тозад"),
            WordModel("Обу по дёди” уу” сэгмидхиз комитад?", "Какое время года тебе нравится?", "Обу по дёд” у сэгмидхиз комитад"),
            WordModel("Чики обу?", "Что это?", "Чики обу?"),
            WordModel("Чики щеэзу”?", "Кто это?", "чики щеэзу"),
            WordModel("Кунь?", "Как это?", "Кунь?"),
            WordModel("Ку”?", "Куда?", "Ку”?"),
            WordModel("Кôки?", "Который?", "Коки?"),
            WordModel("Коз мадь?", "Почему?", "Коз мадь?"),
            WordModel("Тоган?", "Что ты сказал?", "Тоган?"),
            WordModel("Обухун щит перзышь тара?", "Чем тебе помочь?", "Обухун щит перзышь тара"),
            WordModel("Обу ноныд тара?", "Что тебе нужно?", "Обу ноныд тара"),
            WordModel("сыляԑйгу", "белый", "сыляэйгу"),
            WordModel("ползыда", "чёрный", "ползыда"),
            WordModel("налзыда", "красный", "налзыда"),
            WordModel("шудураха", "синий", "шудураха"),
            WordModel("ңараха", "голубой", "ңараха"),
            WordModel("дялдыда", "серый", "дялдыда"),
            WordModel("таску", "жёлтый", "таску"),
            WordModel("одылаха", "зелёный", "одылаха"),
            WordModel("позыраха", "ядовито-зелёный", "позыраха"),
            WordModel("час", "час", "час"),
            WordModel("пи-дери", "сутки", "пи-дери"),
            WordModel("сԑу дери", "неделя", "сԑу дери"),
            WordModel("дири", "месяц", "дири"),
            WordModel("по", "год", "по"),
            WordModel("киузээ", "утро", "киузэ"),
            WordModel("дери", "день", "дери"),
            WordModel("пяушумнээ", "вечер", "пяушумнэ"),
            WordModel("пи", "ночь", "пи"),
            WordModel("четай тахан", "послезавтра", "четай тахан"),
            WordModel("ченую", "вчера", "ченую"),
            WordModel("чей тахан", "позавчера", "чей тахан"),
            WordModel("кудахаан", "давно", "кудахаан"),
            WordModel("тойнукун", "недавно", "тойнукун"),
            WordModel("кунахоо", "когда-то", "кунахоо"),
            WordModel("мôдь", "я", "модь"),
            WordModel("уу”", "ты", "уу"),
            WordModel("бу”", "он", "бу"),
            WordModel("мôдинь”", "мы (двое)", "модинь"),
            WordModel("ууди”", "вы (двое)", "уди"),
            WordModel("буди”", "они (двое)", "буди"),
            WordModel("мôдьна”", "мы (многие)", "модьна"),
            WordModel("ууда”", "вы (многие)", "уда"),
            WordModel("буду”", "они (многие)", "буду"),
            WordModel("ԑки, чики", "этот, эта, это", "эки чики"),
            WordModel("тԑхԑ", "тот, та, то", "тэхэ"),
            WordModel("тою", "тот (дальний)", "тою"),
            WordModel("тойнукуй", "тот (ближний)", "тойнукуй"),
            WordModel("щеэхуру", "никто", "щеэхуру"),
            WordModel("обухуру", "ничто", "обухуру"),
            WordModel("щеэхуру дягу", "никого нет", "щеэхуру дягу"),
            WordModel("обухуру ни озы”", "ничего не видно", "обухуру ни озы"),
            WordModel("щеэ?", "кто?", "щеэ"),
            WordModel("обу?", "что?", "обу"),
            WordModel("курсы?", "какой?", "курсы"),
            WordModel("щеэ?", "чей?", "щеэ"),
            WordModel("кудюлю?", "который? (по счёту)", "кудюлю?"),
            WordModel("сойзаан", "аккуратно", "сойзан"),
            WordModel("ôôдь комачу", "аппетит", "одь комачу"),
            WordModel("леблюку", "бабочка", "леблюку"),
            WordModel("каза", "бабушка", "каза"),
            WordModel("дярчи", "багульчик", "дярчи"),
            WordModel("нԑбидь", "бегать", "нэбидь"),
            WordModel("магутуда", "бедняк", "магутуда"),
            WordModel("ториха", "белка", "ториха"),
            WordModel("сыляԑйгу", "белый", "сыляэйгу"),
            WordModel("лубаха", "бельё", "лубаха"),
            WordModel("лытбирашь", "беречь", "лытбирашь"),
            WordModel("ко", "береза", "ко"),
            WordModel("дя баг, богля баг", "берлога", "дя баг, богля баг"),
            WordModel("дёрима", "беседа", "дёрима"),
            WordModel("дёридь", "беседовать", "дёридь"),
            WordModel("пасиба киташь", "благодарить", "пасиба киташь"),
            WordModel("бены, беныляйгу", "близко", "бены беныляйгу"),
            WordModel("качи", "болезнь", "качи"),
            WordModel("кадыдь", "болеть", "кадыдь"),
            WordModel("нору би”", "болото", "нору би"),
            WordModel("Модь кирба (конфетка, дю) тыдымад комаз", "Я хочу купить хлеба (конфет, масло)", "Модь кирба конфетка дю тыдымад комаз"),
            WordModel("биу", "десять", "биу"),
            WordModel("шизыу", "двадцать", "шизыу"),
            WordModel("нэху биу", "тридцать", "нэху биу"),
            WordModel("тɛт биу", "сорок", "тэт биу"),
            WordModel("собригуу", "пятьдесят", "собригуу"),
            WordModel("мот биу", "шестьдесят", "мот биу"),
            WordModel("сɛу биу", "семьдесят", "сэу биу"),
            WordModel("шизет биу", "восемьдесят", "шизет биу"),
            WordModel("неса биу", "девяносто", "неса биу"),
            WordModel("дюр”", "сто", "дюр"),
            WordModel("тысчи", "тысяча", "тысчи"),
            WordModel("ңôлю", "один", "нолю"),
            WordModel("щизы", "два", "щизы"),
            WordModel("нэху”", "три", "нэху"),
            WordModel("тԑт", "четыре", "тэт"),
            WordModel("собриг", "пять", "собриг"),
            WordModel("моту”", "шесть", "моту"),
            WordModel("сԑу", "семь", "сэу"),
            WordModel("щизыт", "восемь", "щизыт"),
            WordModel("нԑԑсаа", "девять", "нэса"),
            WordModel("озы", "ягода", "озы"),
            WordModel("дичак озы", "брусника", "дичак озы"),
            WordModel("буй", "бульон", "буй"),
            WordModel("кари", "рыба", "кари"),
            WordModel("кари буй", "уха", "кари буй"),
            WordModel("оса", "мясо", "оса"),
            WordModel("кирба", "хлеб", "кирба"),
            WordModel("мона", "яйцо", "мона"),
            WordModel("комиташь", "любить", "комиташь"),
            WordModel("ôôдь", "есть", "ôôдь"),
            WordModel("ойта", "вкусный", "ойта"),
            WordModel("бикоз бозат ңолю", "одинадцать", "бикоз бозат ңолю"),
            WordModel("бикоз бозат шизи", "двенадцать", "бикоз бозат шизи"),
            WordModel("бикоз бозат нэху", "тринадцать", "бикоз бозат нэху"),
            WordModel("бикоз бозат тɛт", "четырнадцать", "бикоз бозат тɛт"),
            WordModel("бикоз бозат собриг", "пятнадцать", "бикоз бозат собриг"),
            WordModel("бикоз бозат моту", "шестнадцать", "бикоз бозат моту"),
            WordModel("бикоз бозат сɛу", "семнадцать", "бикоз бозат сɛу"),
            WordModel("бикоз бозат шизет", "восемнадцать", "бикоз бозат шизет"),
            WordModel("бикоз бозат неса", "девятнадцать", "бикоз бозат неса"),
            WordModel("дю", "масло", "дю"),
            WordModel("лапка", "магазин", "лапка"),
            WordModel("конфетка", "конфета", "конфетка"),
            WordModel("сԑук?", "сколько?", "сэук")
        )

        fun getWordsByName(name: String): ArrayList<WordModel> {
            val sortedWords = ArrayList<WordModel>()

            for(i in 0 until words.size){
                if(words[i].originalWord.lowercase().contains(name.lowercase().replace("?", "").replace("...", "").replace("!", "")) ||
                    words[i].translation.lowercase().contains(name.lowercase().replace("?", "").replace("...", "").replace("!", ""))){
                    sortedWords.add(words[i])
                }
            }
            return sortedWords
        }

        fun getAllWords(): ArrayList<WordModel>{
            return words
        }
    }
}