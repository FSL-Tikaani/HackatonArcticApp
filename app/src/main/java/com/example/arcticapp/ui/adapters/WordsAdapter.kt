package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticapp.Extensions.Companion.toPx
import com.example.arcticapp.data.models.WordModel
import com.example.arcticappfinal.R
import com.example.arcticappfinal.databinding.FragmentWordDetailBinding
import com.example.arcticappfinal.databinding.WordItemBinding
import java.util.*
import kotlin.collections.ArrayList

class WordsAdapter: RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    private var dataList = emptyList<WordModel>()

    @SuppressLint("NotifyDataSetChanged")
    internal fun setDataList(dataList: ArrayList<WordModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: WordItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        //private lateinit var tts: TextToSpeech

        fun bind(word: WordModel) {
            binding.original.text = word.originalWord
            binding.translation.text = word.translation
            /*tts = TextToSpeech(binding.root.context) {
                tts.language = Locale("ru")
            }*/
            binding.listenButton.setOnClickListener {
                //tts.speak(word.originalWord, TextToSpeech.QUEUE_FLUSH, null, "")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(WordItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}