package com.example.arcticapp.ui.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.arcticapp.data.models.PracticeTask
import com.example.arcticapp.ui.lesson.practice.PracticeFragment
import com.example.arcticapp.ui.lesson.theory.TheoryFragment
import com.example.arcticappfinal.R

class LessonTabAdapter(
    activity: FragmentActivity,
    private var lessonID: String
) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            TheoryFragment(lessonID)
        } else {
            PracticeFragment(lessonID)
        }

    override fun getItemCount(): Int = 2
}