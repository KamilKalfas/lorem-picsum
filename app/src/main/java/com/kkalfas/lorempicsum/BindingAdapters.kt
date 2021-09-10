package com.kkalfas.lorempicsum

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BindingAdapters {

    @BindingAdapter("scrollOrientation")
    @JvmStatic fun layoutManager(recyclerView: RecyclerView, layoutOrientation: Int) {
        if (layoutOrientation == RecyclerView.HORIZONTAL) {
            recyclerView.layoutManager = LinearLayoutManager(
                recyclerView.context,
                RecyclerView.HORIZONTAL,
                false
            )
        } else if (layoutOrientation == RecyclerView.VERTICAL) {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        }
    }
}
