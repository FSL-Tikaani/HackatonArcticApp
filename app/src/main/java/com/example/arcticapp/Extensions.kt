package com.example.arcticapp

import android.content.res.Resources

class Extensions {
    companion object {
        fun Int.toPx() = (this * Resources.getSystem().displayMetrics.density).toInt()
    }
}