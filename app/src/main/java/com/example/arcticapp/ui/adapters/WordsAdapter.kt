package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.R

class WordsAdapter(
    private val wordClicked: (word: String) -> Unit
) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    private var dataList = emptyList<WordModel>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: ArrayList<WordModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvWord: TextView
        var tvTranslate: TextView

        init {
            tvWord = itemView.findViewById(R.id.tv_card_view_word)
            tvTranslate = itemView.findViewById(R.id.tv_card_view_translate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_words, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.tvWord.text = item.originalWord
        holder.tvTranslate.text = item.translation

        holder.itemView.setOnClickListener {
            wordClicked(dataList[position].originalWord)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}