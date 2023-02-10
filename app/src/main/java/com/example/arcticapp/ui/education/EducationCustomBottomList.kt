package com.example.arcticapp.ui.education

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.BottomListEducationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EducationCustomBottomList(private val educationItemModel: EducationItemModel,
                                private val clickedItem: (id: String) -> Unit) : BottomSheetDialogFragment(){

    private lateinit var binding: BottomListEducationBinding
    private lateinit var viewModel: EducationBottomViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomListEducationBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[EducationBottomViewModel::class.java]
        viewModel.lessonResults.observe(viewLifecycleOwner) { results ->
            binding.scoreProgress.text = "Получено очков: ${results.score}/${results.maxScore}"
            binding.taskProgress.text = "Заданий выполнено: ${results.taskResult}/${results.maxTasks}"
            if (results.score == results.maxScore) {
                binding.scoreProgress.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.purple_500)
                )
            }
            if (results.taskResult == results.maxTasks) {
                binding.taskProgress.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.purple_500)
                )
            }
        }
        viewModel.loadLessonStatistics(educationItemModel.id)
        binding.tvBottomListEducationNameLesson.text = educationItemModel.name
        binding.tvBottomListEducationDescription.text = educationItemModel.description
        binding.btnBottomListEducationStartEducation.setOnClickListener { clickedItem (educationItemModel.id) }
        binding.imgBottomListEducationImgLesson.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), educationItemModel.icon)
        )

        return binding.root
    }
}