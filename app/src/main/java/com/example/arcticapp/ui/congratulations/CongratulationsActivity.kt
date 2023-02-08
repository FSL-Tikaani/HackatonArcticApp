package com.example.arcticapp.ui.congratulations

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.arcticapp.data.models.TaskResult
import com.example.arcticapp.ui.adapters.TaskAdapter
import com.example.arcticapp.ui.taskSentence.TaskSentenceActivity
import com.example.arcticapp.ui.taskTest.TaskTestActivity
import com.example.arcticapp.ui.taskСompare.TaskCompareActivity
import com.example.arcticappfinal.databinding.ActivityCongratulationsBinding

class CongratulationsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCongratulationsBinding
    private lateinit var viewModel: CongratulationsViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[CongratulationsViewModel::class.java]
        setContentView(binding.root)
        val score = intent.getIntExtra("score", 0)
        val maxscore = intent.getIntExtra("maxscore", 0)
        val taskID = intent.getStringExtra("taskID")!!
        viewModel.addTaskResultToDatabase(TaskResult(taskID, score))
        binding.result.text = "${binding.result.text} $score/$maxscore"
        binding.restart.setOnClickListener {
            restartTask(intent)
        }
        binding.finish.setOnClickListener {
            super.onBackPressed()
        }
        binding.like.animate().alpha(1f).translationY(0f).rotation(-360f)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setListener(object: AnimatorListener {
                override fun onAnimationStart(p0: Animator) {}
                override fun onAnimationEnd(p0: Animator) {
                    animateText()
                }
                override fun onAnimationCancel(p0: Animator) {}
                override fun onAnimationRepeat(p0: Animator) {}
            })
            .duration = 800L
    }

    private fun restartTask(intent: Intent) {
        val type = intent.getIntExtra("type", 0)
        val taskID = intent.getStringExtra("taskID")

        startActivity(Intent(this, when(type) {
            TaskAdapter.TASK_TEST -> TaskTestActivity::class.java
            TaskAdapter.TASK_COMPARE -> TaskCompareActivity::class.java
            TaskAdapter.TASK_SENTENCE -> TaskSentenceActivity::class.java
            else -> TaskTestActivity::class.java
        }).apply { putExtra("taskID", taskID) })
    }

    private fun animateText() {
        binding.congratulationText.animate().alpha(1f).translationY(0f).duration = 500L
        binding.result.animate().alpha(1f).translationY(0f).duration = 500L
        binding.restart.animate().alpha(1f).translationY(0f).duration = 500L
        binding.finish.animate().alpha(1f).translationY(0f).duration = 500L
    }

    override fun onBackPressed() {}
}