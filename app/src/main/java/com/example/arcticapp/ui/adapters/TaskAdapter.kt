package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.PracticeTask
import com.example.arcticapp.data.models.TaskItem
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.TaskItemBinding
import java.util.ArrayList

class TaskAdapter(
    private val onTaskClicked: (task: TaskItem) -> Unit
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    companion object {
        const val TASK_TEST = 0
        const val TASK_SENTENCE = 1
        const val TASK_COMPARE = 2
    }

    private var dataSet = emptyList<TaskItem>()

    class ViewHolder(private val binding: TaskItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(
            practiceTask: TaskItem,
            onTaskClicked: (task: TaskItem) -> Unit
        ) {
            binding.title.text = getTitleString(practiceTask.task.type)
            binding.taskIcon.setImageDrawable( ContextCompat.getDrawable(binding.root.context,
                when(practiceTask.task.type) {
                    TASK_TEST -> R.drawable.ic_baseline_edit_note_24
                    TASK_SENTENCE -> R.drawable.ic_baseline_playlist_add_check_24
                    TASK_COMPARE -> R.drawable.logo_dictation
                    else -> R.drawable.ic_baseline_menu_book_24
                }))
            binding.root.setOnClickListener {
                onTaskClicked(practiceTask)
            }
            if (practiceTask.score > 0) {
                binding.completeLabel.text = "Выполнено: ${practiceTask.score}/${practiceTask.maxScore}"
            }
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
        holder.bind(item) { onTaskClicked(it) }
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(tasks: ArrayList<TaskItem>) {
        dataSet = tasks
        notifyDataSetChanged()
    }
}