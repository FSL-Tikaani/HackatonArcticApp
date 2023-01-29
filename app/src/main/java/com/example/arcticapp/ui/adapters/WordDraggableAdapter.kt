package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.content.ClipData
import android.os.Build
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticappfinal.databinding.WordDraggableItemBinding

class WordDraggableAdapter: RecyclerView.Adapter<WordDraggableAdapter.ViewHolder>() {

    private var dataSet = emptyList<String>()

    class ViewHolder(private val binding: WordDraggableItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: String) {
            binding.word.text = word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            WordDraggableItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
        holder.itemView.setOnTouchListener(object: OnTouchListener {
            @RequiresApi(Build.VERSION_CODES.N)
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val data = ClipData.newPlainText("", "")
                        val shadowBuilder = View.DragShadowBuilder(v)
                        v?.startDragAndDrop(data, shadowBuilder, v, 0)
                        return true
                    }
                }
                return false
            }
        })
        holder.itemView.setOnDragListener(DragListener())
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int = dataSet.size

    fun getList(): List<String> = dataSet

    @SuppressLint("NotifyDataSetChanged")
    fun setDataset(newDataset: MutableList<String>) {
        dataSet = newDataset
        notifyDataSetChanged()
    }
}