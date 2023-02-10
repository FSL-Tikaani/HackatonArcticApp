package com.example.arcticapp.ui.achievements

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.AchievementAdapter
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.AbcSmallItemBinding
import com.example.arcticappfinal.databinding.FragmentAchievementsBinding

class AchievementsFragment : Fragment() {

    private lateinit var viewModel: AchievementsViewModel
    private lateinit var binding: FragmentAchievementsBinding
    private lateinit var adapter: AchievementAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAchievementsBinding.inflate(inflater)
        binding.cross.setOnClickListener {view ->
            Navigation.findNavController(view).popBackStack()
        }
        adapter = AchievementAdapter()
        binding.progressList.layoutManager = LinearLayoutManager(requireContext())
        binding.progressList.adapter = adapter
        viewModel = ViewModelProvider(this)[AchievementsViewModel::class.java]
        viewModel.progress.observe(viewLifecycleOwner) { progress ->
            adapter.setDataset(progress)
        }
        return binding.root
    }

}