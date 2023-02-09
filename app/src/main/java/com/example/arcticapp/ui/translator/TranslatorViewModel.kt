package com.example.arcticapp.ui.translator

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arcticapp.data.api.Translator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TranslatorViewModel : ViewModel() {
    val translatedText: MutableLiveData<String> = MutableLiveData()

    fun translate(input: String, translationMode: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            translatedText.postValue(Translator.translateString(input, translationMode))
        }
    }

}