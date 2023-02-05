package com.example.arcticapp.ui.taskSentence

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.SentenceBuilderAdapter
import com.example.arcticapp.ui.wordDetail.WordDetailFragment
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityTaskSentenceBinding

class TaskSentenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskSentenceBinding
    private lateinit var adapter: SentenceBuilderAdapter
    private lateinit var viewModel: TaskSentenceViewModel
    private var checked = false
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskSentenceBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TaskSentenceViewModel::class.java]
        adapter = SentenceBuilderAdapter { word ->
            WordDetailFragment(word).show(supportFragmentManager, WordDetailFragment.TAG)
        }
        binding.sentences.layoutManager = LinearLayoutManager(this)
        binding.sentences.adapter = adapter
        viewModel.task.observe(this) { task ->
            adapter.setDataSet(task)
        }
        binding.check.setOnClickListener {
            if (!checked) {
                checkTest()
                checked = true
            } else {
                finishTask(score)
            }
        }
        viewModel.loadTask("")
        setContentView(binding.root)
    }

    private fun checkTest() {
        for (i in 0 until adapter.itemCount) {
            val holder = binding.sentences.findViewHolderForAdapterPosition(i)
                as SentenceBuilderAdapter.ViewHolder
            if (holder.checkSentence()) {
                score++
            }
        }
        binding.check.text = applicationContext.getString(R.string.finish)
        binding.check.icon = null
    }

    private fun finishTask(score: Int) {
        // TODO: Переход к итогам
    }
}