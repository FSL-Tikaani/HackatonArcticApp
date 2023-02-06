package com.example.arcticapp.ui.lesson.practice

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticapp.ui.lesson.theory.TheoryViewModel
import com.example.arcticapp.ui.taskSentence.TaskSentenceActivity
import com.example.arcticapp.ui.taskTest.TaskTestActivity
import com.example.arcticapp.ui.taskСompare.TaskCompareActivity
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentPracticeBinding
import com.example.arcticappfinal.databinding.FragmentTheoryBinding

class PracticeFragment(
    private val lessonID: String
) : Fragment() {
    private lateinit var binding: FragmentPracticeBinding
    private lateinit var viewModel: PracticeViewModel
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPracticeBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[PracticeViewModel::class.java]
        adapter = TaskAdapter{ task ->
            val intent = Intent(requireContext(),
            when(task.type) {
                TaskAdapter.TASK_TEST -> TaskTestActivity::class.java
                TaskAdapter.TASK_COMPARE -> TaskCompareActivity::class.java
                TaskAdapter.TASK_SENTENCE -> TaskSentenceActivity::class.java
                else -> {TaskTestActivity::class.java}
            })
            startActivity(intent)
        }
        binding.taskList.layoutManager = LinearLayoutManager(requireContext())
        binding.taskList.adapter = adapter
        viewModel.practiceList.observe(viewLifecycleOwner) { tasks ->
            adapter.setDataSet(tasks)
        }
        viewModel.loadPracticeList(lessonID)
        return binding.root
    }
}