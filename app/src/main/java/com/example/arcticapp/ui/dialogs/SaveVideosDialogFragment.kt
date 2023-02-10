package com.example.arcticapp.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.arcticappfinal.databinding.FragmentCustomDialogSaveVideosBinding

class SaveVideosDialogFragment: DialogFragment() {

    private lateinit var binding:FragmentCustomDialogSaveVideosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentCustomDialogSaveVideosBinding.inflate(inflater)


        return binding.root
    }
}