package com.example.arcticapp.ui.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.ui.adapters.WordsAdapter
import com.example.arcticapp.ui.education.EducationViewModel
import com.example.arcticapp.ui.wordDetail.WordDetailFragment
import com.example.arcticappfinal.databinding.FragmentVocabularyBinding

class VocabularyFragment : Fragment() {

    private var binding: FragmentVocabularyBinding? = null
    private lateinit var adapter: WordsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val educationViewModel =
            ViewModelProvider(this)[VocabularyViewModel::class.java]

        binding = FragmentVocabularyBinding.inflate(inflater, container, false)
        recyclerView = binding!!.recyclerViewWords
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter()
        educationViewModel.liveDataListVocabulary.observe(viewLifecycleOwner){
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