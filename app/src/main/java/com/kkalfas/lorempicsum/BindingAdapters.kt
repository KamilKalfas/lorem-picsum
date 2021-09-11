package com.kkalfas.lorempicsum

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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

    @BindingAdapter("loadAvatar")
    @JvmStatic fun loadAvatar(view: ImageView, url: String) {
        val placeHolder =
            ColorDrawable(ContextCompat.getColor(view.context, android.R.color.darker_gray))
        if (url.isNotBlank()) {
            Glide.with(view.context)
                .load(url)
                .placeholder(placeHolder)
                .circleCrop()
                .into(view)
                .clearOnDetach()
        } else {
            view.setImageDrawable(placeHolder)
        }
    }

    @BindingAdapter("loadPhoto")
    @JvmStatic fun loadPhoto(view: ImageView, url: String) {
        val placeHolder =
            ColorDrawable(ContextCompat.getColor(view.context, android.R.color.darker_gray))
        if (url.isNotEmpty()) {
            Glide.with(view.context)
                .load(url)
                .placeholder(placeHolder)
                .into(view)
                .clearOnDetach()
        } else {
            view.setImageDrawable(placeHolder)
        }
    }
}
