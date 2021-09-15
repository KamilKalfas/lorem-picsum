package com.kkalfas.lorempicsum.discover.ui

import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntDef
import androidx.annotation.LayoutRes
import com.kkalfas.lorempicsum.BR
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.DataBindingProvider
import com.kkalfas.lorempicsum.core.LayoutInflaterProvider
import com.kkalfas.lorempicsum.core.ui.CoreRecycler
import com.kkalfas.lorempicsum.discover.data.PhotoItemDto

private const val INDEX_4 = 4
private const val INDEX_5 = 5

internal class BrowseAllAdapter(
    private val layoutInflaterProvider: LayoutInflaterProvider,
    private val dataBindingProvider: DataBindingProvider
) : CoreRecycler<PhotoItemDto>() {

    override fun onCreateViewHolder(parent: ViewGroup, @PhotoItemType viewType: Int): ViewHolder {
        val inflater = layoutInflaterProvider.get(parent.context)
        @LayoutRes val layoutId = when (viewType) {
            SMALL -> R.layout.discover_browse_all_small_item
            LARGE -> R.layout.discover_browse_all_large_item
            else -> throw IllegalStateException("$viewType not defined in PhotoItemType")
        }
        return ViewHolder(dataBindingProvider.inflate(inflater, layoutId, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindVariable(BR.photoDto, items[position])
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (position % INDEX_5) {
            0, INDEX_4 -> SMALL
            else -> LARGE
        }
        println("PhotoItemType : $type")
        return type
    }

    override fun areItemsTheSame(t1: PhotoItemDto, t2: PhotoItemDto) = t1 == t2

    override fun onItemClick(view: View, item: PhotoItemDto) {
        // todo
    }

    private companion object {
        @Retention(AnnotationRetention.SOURCE)
        @IntDef(value = [SMALL, LARGE])
        annotation class PhotoItemType

        const val SMALL = 1
        const val LARGE = 2
    }
}
