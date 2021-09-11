package com.kkalfas.lorempicsum.discovery.ui

import android.view.View
import android.view.ViewGroup
import com.kkalfas.lorempicsum.BR
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.DataBindingProvider
import com.kkalfas.lorempicsum.core.LayoutInflaterProvider
import com.kkalfas.lorempicsum.core.ui.CoreRecycler
import com.kkalfas.lorempicsum.discovery.data.PhotoItemDto

internal class DiscoveryRecyclerAdapter(
    private val layoutInflaterProvider: LayoutInflaterProvider,
    private val dataBindingProvider: DataBindingProvider
) : CoreRecycler<PhotoItemDto>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = layoutInflaterProvider.get(parent.context)
        return ViewHolder(dataBindingProvider.inflate(inflater, R.layout.discovery_whats_new_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindVariable(BR.photoDto, items[position])
    }

    override fun areItemsTheSame(t1: PhotoItemDto, t2: PhotoItemDto) = t1 == t2

    override fun onItemClick(view: View, item: PhotoItemDto) {
        // todo
    }
}
