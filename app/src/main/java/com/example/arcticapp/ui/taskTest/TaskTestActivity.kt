package com.example.arcticapp.ui.taskTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.TestAdapter
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityTaskTestBinding

class TaskTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskTestBinding
    private lateinit var viewModel: TaskTestViewModel
    private lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskTestBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TaskTestViewModel::class.java]
        adapter = TestAdapter()
        binding.tests.layoutManager = LinearLayoutManager(this)
        binding.tests.adapter = adapter
        viewModel.task.observe(this) { task ->
            adapter.setDataset(task.tasks)
        }
        viewModel.loadTask("")
        setContentView(binding.root)
    }
}