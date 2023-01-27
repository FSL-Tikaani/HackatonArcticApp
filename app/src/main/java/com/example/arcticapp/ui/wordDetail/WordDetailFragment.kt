package com.example.arcticapp.ui.wordDetail

import android.os.Bundle
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

class WordDetailFragment(
    private val word: String
): BottomSheetDialogFragment() {
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
        viewModel = ViewModelProvider(this)[WordDetailViewModel::class.java]
        viewModel.loadWord(word)
        binding.listenButton.setOnClickListener {
            onPlayButtonClicked()
        }
        subscribeToModel()
        return binding.root
    }

    private fun onPlayButtonClicked() {
        if (audioPlayer.isPlaying) {
            binding.listenButton
                .setImageDrawable(ContextCompat.getDrawable(requireContext(),
                    R.drawable.ic_baseline_play_arrow_24))
            audioPlayer.pause()
            return
        }
        if (!audioPlayer.isPlaying) {
            audioPlayer.play()
            binding.listenButton
                .setImageDrawable(ContextCompat.getDrawable(requireContext(),
                    R.drawable.ic_baseline_pause_24))
            return
        }
    }

    private fun createAudioPlayer(): ExoPlayer = ExoPlayer.Builder(requireContext())
        .build().apply {
            setMediaItem(MediaItem.fromUri("https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/a.mp3?alt=media&token=9a129ba3-4abb-42fa-b345-30544694375c"))
            prepare()
            addListener(object: Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    if (audioPlayer.playbackState == ExoPlayer.STATE_ENDED) {
                        audioPlayer.seekTo(0)
                        audioPlayer.playWhenReady = false
                        binding.listenButton
                            .setImageDrawable(ContextCompat.getDrawable(requireContext(),
                                R.drawable.ic_baseline_play_arrow_24))
                    }
                }
            })
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