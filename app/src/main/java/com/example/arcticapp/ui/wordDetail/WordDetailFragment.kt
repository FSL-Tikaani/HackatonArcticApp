package com.example.arcticapp.ui.wordDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager.LayoutParams
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.databinding.FragmentWordDetailBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class WordDetailFragment(
    private val word: String
): DialogFragment() {
    companion object {
        const val TAG = "WordDetailFragment"
    }
    private lateinit var binding: FragmentWordDetailBinding
    private lateinit var viewModel: WordDetailViewModel
    private lateinit var audioPlayer: ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordDetailBinding.inflate(inflater)
        audioPlayer = createAudioPlayer()
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        viewModel = ViewModelProvider(this)[WordDetailViewModel::class.java]
        viewModel.loadWord(word)
        binding.close.setOnClickListener {
            dismiss()
        }
        binding.listenButton.setOnClickListener {
            audioPlayer.play()
        }
        subscribeToModel()
        return binding.root
    }

    private fun createAudioPlayer(): ExoPlayer = ExoPlayer.Builder(requireContext())
        .build().apply {
            setMediaItem(MediaItem.fromUri("https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/a.mp3?alt=media&token=9a129ba3-4abb-42fa-b345-30544694375c"))
            prepare()
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as LayoutParams
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