package com.example.arcticapp.ui.taskСompare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.adapters.DragListener
import com.example.arcticapp.ui.adapters.WordCompareAdapter
import com.example.arcticapp.ui.adapters.WordDraggableAdapter
import com.example.arcticappfinal.databinding.ActivityTaskCompareBinding
import kotlin.math.max

class TaskCompareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskCompareBinding
    private lateinit var viewModel: TaskCompareViewModel
    private lateinit var wordsAdapter: WordDraggableAdapter
    private lateinit var wordsCompareAdapter: WordCompareAdapter
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskCompareBinding.inflate(layoutInflater)
        wordsAdapter = WordDraggableAdapter()
        binding.wordsList.layoutManager = GridLayoutManager(this, 2)
        binding.wordsList.adapter = wordsAdapter
        binding.wordsList.setOnDragListener(DragListener())
        wordsCompareAdapter = WordCompareAdapter(
            { word, position ->
                val holder = binding.compareList.findViewHolderForAdapterPosition(position)
                    as WordCompareAdapter.ViewHolder
                holder.setTranslationLabel("Перевод: $word")
                onWordComparingDone()
            },
            { position ->
                val holder = binding.compareList.findViewHolderForAdapterPosition(position)
                        as WordCompareAdapter.ViewHolder
                holder.setTranslationLabel("Неверный перевод!")
                score = max(score - 1, 0)
            }
        )
        binding.compareList.layoutManager = LinearLayoutManager(this)
        binding.compareList.adapter = wordsCompareAdapter
        binding.compareList.setOnDragListener(DragListener())
        viewModel = ViewModelProvider(this)[TaskCompareViewModel::class.java]
        viewModel.task.observe(this) { task ->
            wordsAdapter.setDataset(task.rusWords)
            score = task.rusWords.size
            wordsCompareAdapter.setDataset(task.enechWords)
        }
        viewModel.loadTask("")
        setContentView(binding.root)
    }

    private fun onWordComparingDone() {
        if (isDone()) {

        }
    }

    private fun isDone(): Boolean = wordsAdapter.itemCount == 0
}