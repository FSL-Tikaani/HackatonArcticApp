package com.example.arcticapp.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.api.API
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticapp.ui.adapters.EducationAdapter
import com.example.arcticappfinal.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    private var binding: FragmentEducationBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EducationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val educationViewModel =
            ViewModelProvider(this)[EducationViewModel::class.java]

        binding = FragmentEducationBinding.inflate(inflater, container, false)

        //recycler view init
        recyclerView = binding!!.recyclerViewEducation
        recyclerView.layoutManager = GridLayoutManager(binding!!.root.context, 2)
        adapter = EducationAdapter()

        educationViewModel.liveDataListItemsEducation.observe(viewLifecycleOwner){
            adapter.setDataList(it)
        }

        recyclerView.adapter = adapter

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}