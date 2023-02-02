package com.example.arcticapp.ui.taskSentence

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arcticappfinal.databinding.ActivityTaskSentenceBinding

class TaskSentenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskSentenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskSentenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}