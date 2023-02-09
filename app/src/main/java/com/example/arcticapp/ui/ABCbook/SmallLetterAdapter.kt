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
        fun bind(letterModel: LetterModel, index: Int) {
            binding.tvLetter.text = letterModel.nameLetter
            binding.tvLetter.setTextColor(Color.parseColor(letterModel.color))
            binding.root.setOnClickListener { clickedItem(letterModel) }
            binding.tvIndex.text = (index + 1).toString()
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