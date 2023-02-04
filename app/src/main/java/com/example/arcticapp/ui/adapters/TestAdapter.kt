package com.example.arcticapp.ui.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.TestItem
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.TestItemBinding


class TestAdapter: RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    private var dataSet = emptyList<TestItem>()

    class ViewHolder(private val binding: TestItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: TestItem
        ) {
            binding.question.text = item.question
            for (i in 0 until item.options.size) {
                val radiobutton = RadioButton(binding.root.context)
                radiobutton.text = item.options[i]
                radiobutton.id = i
                val params = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                )
                radiobutton.background = null
                radiobutton.setButtonDrawable(R.drawable.radiobutton_style)
                radiobutton.buttonTintList = ColorStateList(
                    arrayOf(
                        intArrayOf(android.R.attr.state_checked, android.R.attr.state_pressed),
                        intArrayOf(android.R.attr.state_pressed),
                        intArrayOf(android.R.attr.state_checked),
                        intArrayOf()
                    ),
                    intArrayOf(
                        ContextCompat.getColor(binding.root.context, R.color.darkGray),
                        ContextCompat.getColor(binding.root.context, R.color.purple_500),
                        ContextCompat.getColor(binding.root.context, R.color.purple_500),
                        ContextCompat.getColor(binding.root.context, R.color.darkGray)
                    )
                )
                binding.options.addView(radiobutton, params)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            TestItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataSet.size

    fun setDataset(tasks: ArrayList<TestItem>) {
        dataSet = tasks
        notifyDataSetChanged()
    }
}