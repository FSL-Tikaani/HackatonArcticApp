package com.example.arcticapp.ui.suggestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticappfinal.databinding.FragmentSuggestionsBinding

class SuggestionsFragment : Fragment() {

    private var binding: FragmentSuggestionsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val suggestionsViewModel =
            ViewModelProvider(this)[SuggestionsViewModel::class.java]

        binding = FragmentSuggestionsBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}