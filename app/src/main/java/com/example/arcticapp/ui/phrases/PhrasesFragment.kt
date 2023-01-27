package com.example.arcticapp.ui.phrases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticappfinal.databinding.FragmentPhrasesBinding

class PhrasesFragment : Fragment() {
    private var binding: FragmentPhrasesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val phrasesViewModel =
            ViewModelProvider(this)[PhrasesViewModel::class.java]

        binding = FragmentPhrasesBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}