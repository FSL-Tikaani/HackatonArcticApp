package com.example.arcticapp.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.arcticappfinal.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    private var binding: FragmentEducationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val educationViewModel =
            ViewModelProvider(this)[EducationViewModel::class.java]

        binding = FragmentEducationBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}