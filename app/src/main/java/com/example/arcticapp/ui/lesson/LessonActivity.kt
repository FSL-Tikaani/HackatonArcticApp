package com.example.arcticapp.ui.lesson

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.ActivityLessonBinding

class LessonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonBinding
    private lateinit var adapter: LessonTabAdapter
    private lateinit var textColor: ColorStateList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        binding.cross.setOnClickListener { view ->
            Navigation.findNavController(view).popBackStack()
        }
        val idLesson = intent.getStringExtra("idEducationItem")!!

        Log.d("idItemLessonActivity", idLesson)

        adapter = LessonTabAdapter(this, idLesson)
        binding.pager.adapter = adapter

        binding.buttonTab1.setOnClickListener {
            onTabClicked(0)
        }
        binding.buttonTab2.setOnClickListener {
            onTabClicked(1)
        }
        binding.pager.registerOnPageChangeCallback(object: OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                onTabClicked(position, false)
            }
        })

        textColor = binding.tabText1.textColors
        setContentView(binding.root)
        onTabClicked(0)
    }

    private fun onTabClicked(position: Int, changeTab: Boolean = true) {
        if (changeTab) binding.pager.setCurrentItem(position, true)
        if (position == 0) {
            binding.buttonTab1.setBackgroundResource(R.drawable.tab_background_selected)
            binding.buttonTab2.setBackgroundResource(R.drawable.tab_background)
            binding.tabText1.setTextColor(
                ContextCompat.getColor(this, R.color.white)
            )
            binding.tabText2.setTextColor(textColor)
        }
        if (position == 1) {
            binding.buttonTab1.setBackgroundResource(R.drawable.tab_background)
            binding.buttonTab2.setBackgroundResource(R.drawable.tab_background_selected)
            binding.tabText1.setTextColor(textColor)
            binding.tabText2.setTextColor(
                ContextCompat.getColor(this, R.color.white)
            )
        }
    }
}