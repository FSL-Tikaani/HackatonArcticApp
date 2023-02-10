package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.AchievementItem
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.AchievementItemBinding

class AchievementAdapter: RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {

    private var dataSet = emptyList<AchievementItem>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataset(dataList: ArrayList<AchievementItem>){
        this.dataSet = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: AchievementItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(achievementItem: AchievementItem) {
            binding.lessonName.text = achievementItem.lessonTitle
            binding.scoreProgress.text = "Получено очков: ${achievementItem.lessonResults.score}/${achievementItem.lessonResults.maxScore}"
            binding.taskProgress.text = "Заданий выполнено: ${achievementItem.lessonResults.taskResult}/${achievementItem.lessonResults.maxTasks}"
            if (achievementItem.lessonResults.score == achievementItem.lessonResults.maxScore &&
                achievementItem.lessonResults.taskResult == achievementItem.lessonResults.maxTasks) {
                binding.root.setBackgroundResource(R.drawable.translation_field_background)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            AchievementItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val achievement = dataSet[position]
        holder.bind(achievement)
    }
}