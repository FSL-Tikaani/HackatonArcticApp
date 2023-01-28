package com.example.arcticapp.ui.lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityLessonBinding

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        binding.pager.adapter = LessonTabAdapter(this)
        setContentView(binding.root)
    }
}