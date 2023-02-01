package com.example.arcticapp.ui.congratulations

import android.animation.Animator.AnimatorListener
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.arcticappfinal.databinding.ActivityCongratulationsBinding

class CongratulationsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCongratulationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.like.animate().alpha(1f).translationY(0f).rotation(-360f)
            .setInterpolator(AccelerateDecelerateInterpolator())
//            .setListener(
//                object: AnimatorListener
//            )
            .duration = 800L
    }
}