package com.example.arcticapp.ui.taskTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.SentenceBuilderAdapter
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticapp.ui.adapters.TestAdapter
import com.example.arcticapp.ui.congratulations.CongratulationsActivity
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityTaskTestBinding

class TaskTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskTestBinding
    private lateinit var viewModel: TaskTestViewModel
    private lateinit var adapter: TestAdapter
    private var taskID: Int = 0
    private var checked = false
    private var score = 0

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
        binding.check.setOnClickListener {
            if (!checked) {
                checkTest()
                checked = true
            } else {
                finishTask(score)
            }
        }
        setContentView(binding.root)
    }

    private fun checkTest() {
        for (i in 0 until adapter.itemCount) {
            val holder = binding.tests.findViewHolderForAdapterPosition(i)
                    as TestAdapter.ViewHolder
            if (holder.checkTask()) {
                score++
            }
        }
        binding.check.text = applicationContext.getString(R.string.finish)
        binding.check.icon = null
    }

    private fun finishTask(score: Int) {
        val maxScore = adapter.itemCount
        startActivity(Intent(this, CongratulationsActivity::class.java)
            .apply {
                putExtra("score", score)
                putExtra("maxscore", maxScore)
                putExtra("type", TaskAdapter.TASK_TEST)
                putExtra("taskID", "lesson1_1")
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
    }
}