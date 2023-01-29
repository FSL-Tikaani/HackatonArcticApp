package com.example.arcticapp.ui.lesson.theory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentTheoryBinding

class TheoryFragment(
    private val lessonID: String
) : Fragment() {
    private lateinit var binding: FragmentTheoryBinding
    private lateinit var viewModel: TheoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTheoryBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[TheoryViewModel::class.java]
        viewModel.theory.observe(viewLifecycleOwner) { theory ->
            binding.description.text = theory.description
        }
        viewModel.loadTheory(lessonID)
        return binding.root
    }

}