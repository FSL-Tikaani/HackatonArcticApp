package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.SentenceItem
import com.example.arcticapp.data.models.SentenceTask
import com.example.arcticappfinal.databinding.SentenceBuilderItemBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class SentenceBuilderAdapter(
    private val onWordTipClicked: (word: String) -> Unit
): RecyclerView.Adapter<SentenceBuilderAdapter.ViewHolder>() {

    private var dataSet = emptyList<SentenceItem>()

    class ViewHolder(private val binding: SentenceBuilderItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var adapter: WordClickableAdapter

        fun bind(
            sentenceItem: SentenceItem,
            onWordTipClicked: (word: String) -> Unit,
            index: Int
        ) {
            // TODO: Обработка нажатия
            adapter = WordClickableAdapter(onWordTipClicked) {}
            adapter.setDataSet(sentenceItem.words)
            binding.words.layoutManager =
                FlexboxLayoutManager(itemView.context, FlexDirection.ROW, FlexWrap.WRAP)
            binding.words.adapter = adapter
            binding.russianSentence.text = "$index: ${sentenceItem.russianSentence}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            SentenceBuilderItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sentenceItem = dataSet[position]
        holder.bind(sentenceItem, { onWordTipClicked(it) }, position+1)
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(task: SentenceTask) {
        dataSet = task.sentences
        notifyDataSetChanged()
    }
}