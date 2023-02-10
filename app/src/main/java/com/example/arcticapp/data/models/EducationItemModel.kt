package com.example.arcticapp.data.models

import com.example.arcticappfinal.R

data class EducationItemModel (
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val icon: Int = R.drawable.education_item_img,
    val tasks: Int = 3,
    val fileVideoName: String = "video1.mp4",
    val urlVideo: String = "https://firebasestorage.googleapis.com/v0/b/time-mashine-minsk.appspot.com/o/1.mp4?alt=media&token=9b314df0-9220-416e-92fe-f9e9e8230b62"
)