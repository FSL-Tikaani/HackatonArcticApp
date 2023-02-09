package com.example.arcticapp.ui.ABCbook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.LetterModel
import com.example.arcticapp.ui.dialogs.LetterInfoDialog
import com.example.arcticapp.ui.education.EducationCustomBottomList
import com.example.arcticapp.ui.lesson.LessonActivity
import com.example.arcticappfinal.databinding.FragmentABCbookBinding

class ABCbookFragment : Fragment() {

    private lateinit var binding: FragmentABCbookBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SmallLetterAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val educationViewModel = ViewModelProvider(this)[ABCbookViewModel::class.java]
        binding = FragmentABCbookBinding.inflate(inflater, container, false)

        //init recycler
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(binding.root.context, 3)

        adapter = SmallLetterAdapter { item ->
            LetterInfoDialog(item).show(childFragmentManager, "tag")
        }
        educationViewModel.letters.observe(viewLifecycleOwner){
            adapter.setDataList(it)
        }
        recyclerView.adapter = adapter

        return binding.root
    }
}