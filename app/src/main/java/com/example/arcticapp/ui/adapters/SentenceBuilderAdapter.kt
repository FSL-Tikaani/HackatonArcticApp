package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.SentenceItem
import com.example.arcticapp.data.models.SentenceTask
import com.example.arcticappfinal.R
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
        private lateinit var task: SentenceItem

        @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
        fun bind(
            sentenceItem: SentenceItem,
            onWordTipClicked: (word: String) -> Unit,
            index: Int
        ) {
            task = sentenceItem
            adapter = WordClickableAdapter(
                onWordTipClicked,
                {onWordInserted(it)},
                { binding.words.post { it.run() }  },
                binding.enechSentence)
            adapter.setDataSet(sentenceItem.words)
            binding.words.layoutManager =
                FlexboxLayoutManager(itemView.context, FlexDirection.ROW, FlexWrap.WRAP)
            binding.words.adapter = adapter
            binding.russianSentence.text = "$index: ${sentenceItem.russianSentence}"
            binding.refresh.setOnClickListener {
                binding.enechSentence.text = ""
                binding.words.post {
                    adapter.refresh()
                }
            }
        }

        @SuppressLint("SetTextI18n")
        private fun onWordInserted(word: String) {
            binding.enechSentence.text = "${binding.enechSentence.text} $word"
        }

        fun checkSentence(): Boolean {
            val isCorrect = binding.enechSentence.text.trim() == task.correctSentence
            binding.checkResult.visibility = View.VISIBLE
            binding.enechSentence.setTextColor(ContextCompat.getColor(binding.root.context,
                if (isCorrect) R.color.green else R.color.red)
            )
            if (!isCorrect) {
                binding.checkResult.text = task.correctSentence
            }
            binding.refresh.setOnClickListener(null)
            binding.refresh.isClickable = false
            binding.refresh.isFocusable = false
            deactivateWordButtons()
            return isCorrect
        }

        private fun deactivateWordButtons() {
            for (i in 0 until adapter.itemCount) {
                val holder = binding.words.findViewHolderForAdapterPosition(i)
                        as WordClickableAdapter.ViewHolder
                holder.deactivateWordButton()
            }
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