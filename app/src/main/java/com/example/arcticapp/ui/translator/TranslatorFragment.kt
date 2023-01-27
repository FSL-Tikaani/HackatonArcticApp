package com.example.arcticapp.ui.translator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticappfinal.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment() {

    private var binding: FragmentTranslatorBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val translatorViewModel =
            ViewModelProvider(this)[TranslatorViewModel::class.java]

        binding = FragmentTranslatorBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}