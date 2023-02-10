package com.example.arcticapp.ui.translator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.arcticapp.data.api.Translator
import com.example.arcticappfinal.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment() {

    private var binding: FragmentTranslatorBinding? = null
    private lateinit var viewModel: TranslatorViewModel
    private var translationMode = Translator.TRANSLATION_MODE_RUS_TO_ENECH

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[TranslatorViewModel::class.java]
        binding = FragmentTranslatorBinding.inflate(inflater, container, false)
        binding!!.changeLanguages.setOnClickListener {
            translationMode = if (translationMode == Translator.TRANSLATION_MODE_RUS_TO_ENECH) {
                Translator.TRANSLATION_MODE_ENECH_TO_RUS
            } else {
                Translator.TRANSLATION_MODE_RUS_TO_ENECH
            }
            swapText()
            changeLanguageTitles()
        }
        binding!!.cross.setOnClickListener { view ->
            Navigation.findNavController(view).popBackStack()
        }
        binding!!.translateButton.setOnClickListener {
            viewModel.translate(binding!!.input.text.toString(), translationMode)
        }
        viewModel.translatedText.observe(viewLifecycleOwner) { translation ->
            binding!!.output.text = translation
        }
        setupSpecialSymbols()
        return binding!!.root
    }

    private fun swapText() {
        var translation = binding!!.output.text
        if (translation == "Перевод...") translation = ""
        binding!!.output.text = binding!!.input.text.toString()
        binding!!.input.setText(translation)
    }

    private fun setupSpecialSymbols() {
        binding!!.letterE.setOnClickListener {
            binding!!.input.append("ԑ")
        }
        binding!!.letterN.setOnClickListener {
            binding!!.input.append("ң")
        }
        binding!!.letterApostroph.setOnClickListener {
            binding!!.input.append("ô")
        }
        binding!!.letterDoubleApostroph.setOnClickListener {
            binding!!.input.append("”")
        }
    }

    private fun changeLanguageTitles() {
        if (translationMode == Translator.TRANSLATION_MODE_ENECH_TO_RUS) {
            binding!!.fromLanguage.text = "Энецкий"
            binding!!.toLanguage.text = "Русский"
        } else {
            binding!!.fromLanguage.text = "Русский"
            binding!!.toLanguage.text = "Энецкий"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}