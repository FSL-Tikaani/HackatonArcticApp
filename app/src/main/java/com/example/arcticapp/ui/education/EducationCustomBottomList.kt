package com.example.arcticapp.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.BottomListEducationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EducationCustomBottomList(private val educationItemModel: EducationItemModel,
                                private val clickedItem: (id: String) -> Unit) : BottomSheetDialogFragment(){

    private lateinit var binding: BottomListEducationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomListEducationBinding.inflate(inflater)

        //add data to tv
        binding.tvBottomListEducationNameLesson.text = educationItemModel.name
        binding.tvBottomListEducationProgress.text = "10/10"
        binding.tvBottomListEducationDescription.text = educationItemModel.description
        binding.btnBottomListEducationStartEducation.setOnClickListener { clickedItem (educationItemModel.id) }

        return binding.root
    }
}