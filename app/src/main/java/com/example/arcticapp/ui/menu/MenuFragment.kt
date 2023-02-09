package com.example.arcticapp.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)
        binding.educationBlock.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigation_education)
        }
        binding.dictionaryBlock.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigation_vocabulary)
        }
        binding.accountBlock.setOnClickListener {
            // TODO: Account navigation
        }
        binding.translatorBlock.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigation_translator)
        }
        binding.abcBlock.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.navigation_abc)
        }
        return binding.root
    }
}