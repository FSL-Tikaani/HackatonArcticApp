package com.example.arcticapp

import android.content.res.Resources
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Extensions {
    companion object {
        fun Int.toPx() = (this * Resources.getSystem().displayMetrics.density).toInt()

        val gson = Gson()
        fun <T> T.serializeToMap(): Map<Any, Any> {
            return convert()
        }
        inline fun <reified T> Map<Any, Any>.toDataClass(): T {
            return convert()
        }
        inline fun <I, reified O> I.convert(): O {
            val json = gson.toJson(this)
            return gson.fromJson(json, object : TypeToken<O>() {}.type)
        }
    }
}