package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticappfinal.databinding.WordClickableItemBinding

class WordClickableAdapter(
    private val onWordTipClicked: (word: String) -> Unit,
    private val onWordClicked: (word: String) -> Unit
): RecyclerView.Adapter<WordClickableAdapter.ViewHolder>() {

    private var dataSet = emptyList<String>()

    class ViewHolder(private val binding: WordClickableItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            word: String,
            onWordTipClicked: (word: String) -> Unit,
            onWordClicked: (word: String) -> Unit) {
            binding.word.text = word
            binding.tip.setOnClickListener {
                onWordTipClicked(word)
            }
            binding.root.setOnClickListener{
                onWordClicked(word)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            WordClickableItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item, {onWordTipClicked(it)}, {onWordClicked(it)})
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(newDataSet: ArrayList<String>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }
}