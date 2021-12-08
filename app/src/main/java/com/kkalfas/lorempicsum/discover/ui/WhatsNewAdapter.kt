package com.kkalfas.lorempicsum.discover.ui

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.DataBindingProvider
import com.kkalfas.lorempicsum.core.LayoutInflaterProvider
import com.kkalfas.lorempicsum.core.ui.CoreRecycler
import com.kkalfas.lorempicsum.discover.data.PhotoItemDto

internal class WhatsNewAdapter(
    private val layoutInflaterProvider: LayoutInflaterProvider,
    private val dataBindingProvider: DataBindingProvider
) : CoreRecycler<PhotoItemDto>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = layoutInflaterProvider.get(parent.context)
        return ViewHolder(dataBindingProvider.inflate(inflater, R.layout.discover_whats_new_list_item, parent, false))
    }

    override fun areItemsTheSame(t1: PhotoItemDto, t2: PhotoItemDto) = t1 == t2

    override fun onItemClick(view: View, item: PhotoItemDto) {
        val action = DiscoverFragmentDirections.actionDiscoverFragmentToPhotoFragment(item)
        view.findNavController().navigate(action)
    }
}
