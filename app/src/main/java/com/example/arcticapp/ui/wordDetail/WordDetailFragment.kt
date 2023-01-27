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

class WordDetailFragment(
    private val word: String
): DialogFragment() {
    companion object {
        const val TAG = "WordDetailFragment"
    }
    private lateinit var binding: FragmentWordDetailBinding
    private lateinit var viewModel: WordDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordDetailBinding.inflate(inflater)
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        viewModel = ViewModelProvider(this)[WordDetailViewModel::class.java]
        viewModel.loadWord(word)
        binding.close.setOnClickListener {
            dismiss()
        }
        subscribeToModel()
        return binding.root
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