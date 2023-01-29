package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.PracticeTask
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.TaskItemBinding
import java.util.ArrayList

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    companion object {
        const val TASK_TEST = 0
        const val TASK_SENTENCE = 1
        const val TASK_COMPARE = 2
    }

    private var dataSet = emptyList<PracticeTask>()

    class ViewHolder(private val binding: TaskItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(practiceTask: PracticeTask) {
            binding.title.text = getTitleString(practiceTask.type)
        }
        private fun getTitleString(taskType: Int): String = when(taskType) {
            TASK_TEST -> itemView.context.getString(R.string.test)
            TASK_SENTENCE -> itemView.context.getString(R.string.sentences)
            TASK_COMPARE -> itemView.context.getString(R.string.comparing)
            else -> ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            TaskItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(tasks: ArrayList<PracticeTask>) {
        dataSet = tasks
        notifyDataSetChanged()
    }
}