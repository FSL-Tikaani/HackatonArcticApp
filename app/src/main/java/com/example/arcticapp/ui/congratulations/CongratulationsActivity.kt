package com.example.arcticapp.ui.congratulations

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.arcticappfinal.databinding.ActivityCongratulationsBinding

class CongratulationsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCongratulationsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score = intent.getIntExtra("score", 0)
        val maxscore = intent.getIntExtra("maxscore", 0)
        binding.result.text = "${binding.result.text} $score/$maxscore"
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

    private fun animateText() {
        binding.congratulationText.animate().alpha(1f).translationY(0f).duration = 500L
        binding.result.animate().alpha(1f).translationY(0f).duration = 500L
        binding.restart.animate().alpha(1f).translationY(0f).duration = 500L
        binding.finish.animate().alpha(1f).translationY(0f).duration = 500L
    }

    override fun onBackPressed() {}
}