package com.example.arcticapp.ui.vocabulary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.WordModel
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
        val vocabularyViewModel =
            ViewModelProvider(this)[VocabularyViewModel::class.java]

        binding = FragmentVocabularyBinding.inflate(inflater, container, false)
        recyclerView = binding!!.recyclerViewWords
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter()

        updateDataRecycler(vocabularyViewModel.liveDataListVocabulary)

        recyclerView.adapter = adapter

        binding!!.btnSearch.setOnClickListener {
            val dataSearch = binding!!.tvSearch.text.toString()

            vocabularyViewModel.searchByName(dataSearch)
            updateDataRecycler(vocabularyViewModel.liveDataListVocabulary)
        }

        return binding!!.root
    }

    private fun updateDataRecycler(liveDataListVocabulary: MutableLiveData<ArrayList<WordModel>>){
        liveDataListVocabulary.observe(viewLifecycleOwner){
            adapter.setDataList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}