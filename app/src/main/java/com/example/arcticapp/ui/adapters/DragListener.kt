package com.example.arcticapp.ui.adapters

import android.view.DragEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.arcticappfinal.R

class DragListener : View.OnDragListener {
    private var isDropped = false
    override fun onDrag(v: View, event: DragEvent): Boolean {
        when (event.action) {
            DragEvent.ACTION_DROP -> {
                isDropped = true
                var positionTarget = -1
                val viewSource = event.localState as View?
                val viewId = v.id
                val frameLayoutItem = R.id.compareItem
                when (viewId) {
                    frameLayoutItem -> {
                        val target: RecyclerView = v.parent as RecyclerView
                        positionTarget = v.tag as Int
                        if (viewSource != null) {
                            val source = viewSource.parent as RecyclerView
                            val adapterSource = source.adapter as WordDraggableAdapter?
                            val positionSource = viewSource.tag as Int
                            val wordToCompare: String? = adapterSource?.getList()?.get(positionSource)
                            val adapterTarget = target.adapter as WordCompareAdapter?
                            var compareSuccess = false
                            wordToCompare?.let {
                                compareSuccess = adapterTarget?.compare(it, positionTarget) == true
                            }
                            if (compareSuccess) {
                                val listSource = adapterSource?.getList()?.toMutableList()?.apply {
                                    removeAt(positionSource)
                                }
                                listSource?.let { adapterSource.setDataset(it) }
                            }
                        }
                    }
                }
            }
        }
        if (!isDropped && event.localState != null) {
            (event.localState as View).visibility = View.VISIBLE
        }
        return true
    }
}