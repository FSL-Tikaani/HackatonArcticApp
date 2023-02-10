package com.example.arcticapp.ui.adapters

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.SentenceWord
import com.example.arcticappfinal.databinding.WordClickableItemBinding


class WordClickableAdapter(
    private val onWordTipClicked: (word: SentenceWord) -> Unit,
    private val onWordAnimationFinished: (word: SentenceWord) -> Unit,
    private val onWordClickedPost: (runnable: Runnable) -> Unit,
    private var sentenceView: View
): RecyclerView.Adapter<WordClickableAdapter.ViewHolder>() {

    private var dataSet = emptyList<SentenceWord>()
    private var dataBackup = emptyList<SentenceWord>()

    class ViewHolder(private val binding: WordClickableItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        private var clicked = false

        fun bind(
            word: SentenceWord,
            onWordTipClicked: (word: SentenceWord) -> Unit,
            onWordAnimationFinished: (word: SentenceWord) -> Unit,
            sentenceView: View
        ) {
            clicked = false
            restorePosition(binding.root)
            binding.word.text = word.word
            if (word.hasTranslation) {
                binding.tip.setOnClickListener {
                    onWordTipClicked(word)
                }
            } else {
                binding.tip.visibility = View.GONE
            }
            binding.root.setOnClickListener{
                if (!clicked) {
                    clicked = true
                    animateWordMovement(binding.root, sentenceView) {
                        onWordAnimationFinished(word)
                    }
                }
            }
        }

        private fun animateWordMovement(
            wordItem: View,
            sentenceView: View,
            onWordAnimationFinished: () -> Unit,
        ) {
            val offsetX = sentenceView.x - wordItem.x
            val offsetY = sentenceView.y - wordItem.y
            wordItem.animate()
                .setListener(object: AnimatorListener {
                    override fun onAnimationStart(p0: Animator) {}
                    override fun onAnimationEnd(p0: Animator) {
                        onWordAnimationFinished()
                    }
                    override fun onAnimationCancel(p0: Animator) {}
                    override fun onAnimationRepeat(p0: Animator) {}
                })
                .translationX(offsetX).translationY(offsetY).alpha(0f).duration = 400L
        }

        private fun restorePosition(
            wordItem: View,
        ) {
            wordItem.animate()
                .translationX(0f).translationY(0f).alpha(1f).duration = 0L
        }

        fun deactivateWordButton() {
            binding.root.setOnClickListener(null)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            WordClickableItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item, {onWordTipClicked(it)},
            {
                onWordAnimationFinished(it)
                removeItem(it.word)
            }, sentenceView)
    }

    private fun removeItem(word: String) {
        onWordClickedPost(Runnable {
            val newDataset = dataSet.toMutableList()
            val wordToRemove = newDataset.find { item -> item.word == word }
            val position = newDataset.indexOf(wordToRemove)
            newDataset.remove(wordToRemove)
            dataSet = newDataset
            notifyItemRemoved(position)
        })
    }

    override fun getItemCount(): Int = dataSet.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(newDataSet: ArrayList<SentenceWord>) {
        dataSet = newDataSet
        dataBackup = newDataSet
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refresh() {
        dataSet = dataBackup
        notifyDataSetChanged()
    }
}