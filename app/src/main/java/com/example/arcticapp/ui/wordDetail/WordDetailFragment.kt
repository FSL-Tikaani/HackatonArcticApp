package com.example.arcticapp.ui.wordDetail

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager.LayoutParams
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentWordDetailBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

class WordDetailFragment(
    private val word: String
): BottomSheetDialogFragment() {
    companion object {
        const val TAG = "WordDetailFragment"
    }
    private lateinit var binding: FragmentWordDetailBinding
    private lateinit var viewModel: WordDetailViewModel
    private lateinit var tts: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordDetailBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[WordDetailViewModel::class.java]
        viewModel.loadWord(word)
        tts = TextToSpeech(requireContext()) {
            tts.language = Locale("ru")
        }
        binding.listenButton.setOnClickListener {
            tts.speak("мэнду", TextToSpeech.QUEUE_FLUSH, null, "")
        }
        subscribeToModel()
        return binding.root
    }

    private fun subscribeToModel() {
        viewModel.wordInfo.observe(viewLifecycleOwner) { wordModel ->
            displayWordData(wordModel)
            fadeIn()
        }
    }

    private fun displayWordData(wordModel: WordModel) {
        binding.original.text = wordModel.originalWord
        binding.translation.text = wordModel.translation
    }

    private fun fadeIn() {
        binding.original.animate().alpha(1f).duration = 500L
        binding.translation.animate().alpha(1f).duration = 500L
    }
}