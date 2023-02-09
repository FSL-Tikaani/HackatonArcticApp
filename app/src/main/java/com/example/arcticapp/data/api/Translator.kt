package com.example.arcticapp.data.api

import com.example.arcticapp.data.database.DictionaryStorage

class Translator {
    companion object {
        const val TRANSLATION_MODE_RUS_TO_ENECH = 0
        const val TRANSLATION_MODE_ENECH_TO_RUS = 1

        fun translateString(originalString: String, mode: Int): String =
            when (mode) {
                TRANSLATION_MODE_RUS_TO_ENECH -> translateToEnech(originalString)
                TRANSLATION_MODE_ENECH_TO_RUS -> translateToEnech(originalString)
                else -> {originalString}
            }

        private fun translateToEnech(originalString: String): String {
            var result = originalString
            API.getWordsList("All").forEach { word ->
                if (result.lowercase().contains(word.translation.lowercase().replace("?", "").replace("...", "").replace("!", ""))) {
                    result = result.replace(
                        word.translation.lowercase().replace("?", "").replace("...", "").replace("!", ""),
                        word.originalWord.lowercase().replace("?", "").replace("...", "").replace("!", "")
                    )
                }
            }
            return result
        }
    }
}