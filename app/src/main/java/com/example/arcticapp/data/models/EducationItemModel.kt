package com.example.arcticapp.data.models

import com.example.arcticappfinal.R

data class EducationItemModel (
    val name: String = "",
    val description: String = "",
    val icon: Int = R.drawable.education_item_img,
    val srcVideo: Int = R.raw.video1,
    val id: String = "",
    val tasks: Int = 3
)