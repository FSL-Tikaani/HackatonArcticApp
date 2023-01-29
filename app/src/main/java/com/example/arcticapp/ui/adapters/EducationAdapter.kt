package com.example.arcticapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arcticapp.data.models.EducationItemModel
import com.example.arcticappfinal.databinding.EducationItemBinding

class EducationAdapter: RecyclerView.Adapter<EducationAdapter.ViewHolder>(){

     private var dataList = emptyList<EducationItemModel>()

     @SuppressLint("NotifyDataSetChanged")
     internal fun setDataList(dataList: ArrayList<EducationItemModel>){
          this.dataList = dataList
          notifyDataSetChanged()
     }

     class ViewHolder(private val binding: EducationItemBinding):
          RecyclerView.ViewHolder(binding.root) {
          fun bind(educationItem: EducationItemModel) {
               binding.tvItemEducation.text = educationItem.name
               Glide.with(binding.root).load(educationItem.icon).into(binding.imgItemEducation)
          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
          ViewHolder(
               EducationItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
          )

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val item = dataList[position]
          holder.bind(item)
     }

     override fun getItemCount(): Int {
          return dataList.size
     }
}