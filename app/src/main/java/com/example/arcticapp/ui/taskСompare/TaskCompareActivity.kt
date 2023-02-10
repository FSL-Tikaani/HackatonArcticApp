package com.example.arcticapp.ui.taskСompare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arcticapp.ui.MainActivity
import com.example.arcticapp.ui.adapters.DragListener
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticapp.ui.adapters.WordCompareAdapter
import com.example.arcticapp.ui.adapters.WordDraggableAdapter
import com.example.arcticapp.ui.congratulations.CongratulationsActivity
import com.example.arcticapp.ui.dialogs.ExitDialogFragment
import com.example.arcticapp.ui.dialogs.QuestionDialogFragment
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityTaskCompareBinding
import kotlin.math.max

class TaskCompareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskCompareBinding
    private lateinit var viewModel: TaskCompareViewModel
    private lateinit var wordsAdapter: WordDraggableAdapter
    private lateinit var wordsCompareAdapter: WordCompareAdapter
    private var taskID: String = ""
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskID = intent.getStringExtra("taskID")!!
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
                holder.animateCorrectly()
                onWordComparingDone()
            },
            { position ->
                val holder = binding.compareList.findViewHolderForAdapterPosition(position)
                        as WordCompareAdapter.ViewHolder
                holder.setTranslationLabel("Неверный перевод!")
                holder.animateWrongly()
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

        viewModel.loadTask(taskID)
        setContentView(binding.root)

        //on Click
        binding.tip.setOnClickListener {
            //reference
            //передаём R.string.answer_text для подстановки в TextView DialogFragment
            val myQuestionDialog = QuestionDialogFragment(R.string.answer_text2)
            val manager = supportFragmentManager
            myQuestionDialog.show(manager, "")
        }
        //exit to ???
        binding.cross.setOnClickListener {
            openExitDialog()
        }
    }

    private fun openExitDialog() {
        val myExitDialog = ExitDialogFragment{
            super.onBackPressed()
        }
        val manager = supportFragmentManager
        myExitDialog.show(manager, "")
    }

    override fun onBackPressed() {
        openExitDialog()
    }

    private fun onWordComparingDone() {
        if (isDone()) {
            finishTask(score)
        }
    }

    private fun finishTask(score: Int) {
        val maxScore = wordsCompareAdapter.itemCount
        startActivity(Intent(this, CongratulationsActivity::class.java)
            .apply {
                putExtra("score", score)
                putExtra("maxscore", maxScore)
                putExtra("type", TaskAdapter.TASK_COMPARE)
                putExtra("taskID", taskID)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
    }

    private fun isDone(): Boolean = wordsAdapter.itemCount == 1
}