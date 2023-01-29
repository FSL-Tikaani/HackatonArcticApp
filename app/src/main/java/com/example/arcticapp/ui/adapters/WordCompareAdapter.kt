package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.CompareWord
import com.example.arcticappfinal.databinding.WordCompareItemBinding

class WordCompareAdapter(
    private val onWordInserted: (word:String, position: Int) -> Unit,
    private val onWordInsertedWrongly: (position: Int) -> Unit,
): RecyclerView.Adapter<WordCompareAdapter.ViewHolder>() {

    private var dataSet = emptyList<CompareWord>()

    class ViewHolder(private val binding: WordCompareItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(word: CompareWord, index: Int) {
            binding.originalWord.text = "$index: ${word.original}"
        }

        fun setTranslationLabel(text: String) {
            binding.translation.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            WordCompareItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item, position+1)
        holder.itemView.tag = position
        holder.itemView.setOnDragListener(DragListener())
    }

    override fun getItemCount(): Int = dataSet.size

    fun getList(): List<CompareWord> = dataSet

    @SuppressLint("NotifyDataSetChanged")
    fun setDataset(newDataset: MutableList<CompareWord>) {
        dataSet = newDataset
        notifyDataSetChanged()
    }

    fun compare(it: String, position: Int): Boolean {
        if (dataSet[position].done) return false
        val successful = it == dataSet[position].rus
        if (successful) {
            onWordInserted(it, position)
            dataSet[position].done = true
        } else {
            onWordInsertedWrongly(position)
        }
        return successful
    }
}