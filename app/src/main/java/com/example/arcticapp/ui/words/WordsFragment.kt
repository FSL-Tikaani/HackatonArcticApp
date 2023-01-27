package com.example.arcticapp.ui.words

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.ui.adapters.WordsAdapter
import com.example.arcticapp.ui.wordDetail.WordDetailFragment
import com.example.arcticappfinal.databinding.FragmentWordsBinding

class WordsFragment : Fragment() {

    private var binding: FragmentWordsBinding? = null
    private lateinit var adapter: WordsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val wordsViewModel =
            ViewModelProvider(this)[WordsViewModel::class.java]

        binding = FragmentWordsBinding.inflate(inflater, container, false)
        //inint recycler view
        recyclerView = binding!!.recyclerViewWords
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = WordsAdapter{ word ->
            WordDetailFragment(word).show(childFragmentManager, WordDetailFragment.TAG)
        }
        wordsViewModel.liveDataListWords.observe(viewLifecycleOwner){
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