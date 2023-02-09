package com.example.arcticapp.ui.ABCbook

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.LetterModel
import com.example.arcticappfinal.databinding.AbcSmallItemBinding

class SmallLetterAdapter(private val clickedItem: (item: LetterModel) -> Unit):
    RecyclerView.Adapter<SmallLetterAdapter.ViewHolder>(){

    private var dataList = emptyList<LetterModel>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: ArrayList<LetterModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: AbcSmallItemBinding, private val clickedItem: (model: LetterModel) -> Unit):
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(letterModel: LetterModel, index: Int) {
            binding.tvLetter.text = letterModel.letter
            binding.root.setOnClickListener { clickedItem(letterModel) }
            var letterIndex = (index + 1).toString()
            if (letterIndex.length == 1) letterIndex = "0$letterIndex"
            binding.tvIndex.text = letterIndex
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            AbcSmallItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false), clickedItem
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}