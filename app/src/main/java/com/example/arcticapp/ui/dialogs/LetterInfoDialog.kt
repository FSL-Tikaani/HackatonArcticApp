package com.example.arcticapp.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.arcticapp.data.models.LetterModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.CustomDialogLetterInfoBinding
import java.util.*

class LetterInfoDialog(private var letterModel: LetterModel) : AppCompatDialogFragment() {

    private lateinit var binding: CustomDialogLetterInfoBinding
    private lateinit var tts: TextToSpeech

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = CustomDialogLetterInfoBinding.inflate(LayoutInflater.from(context))
        binding.letter.text = letterModel.letter
        binding.wordOriginal.text = letterModel.word.originalWord
        binding.translation.text = letterModel.word.translation
        binding.letterIllustration.setImageDrawable(ContextCompat.getDrawable(
            requireContext(), letterModel.illustration
        ))

        tts = TextToSpeech(binding.root.context) {
            tts.language = Locale("ru")
        }

        binding.voice.setOnClickListener {
            val a = letterModel
            tts.speak(letterModel.word.transcription, TextToSpeech.QUEUE_FLUSH, null, "")
        }

        return AlertDialog.Builder(this.context)
            .setView(binding.root)
            .create()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}