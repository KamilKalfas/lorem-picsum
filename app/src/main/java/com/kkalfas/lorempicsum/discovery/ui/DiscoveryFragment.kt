package com.kkalfas.lorempicsum.discovery.ui

import android.os.Bundle
import android.view.View
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.DataBindingProvider
import com.kkalfas.lorempicsum.core.LayoutInflaterProvider
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.DiscoveryFragmentBinding
import com.kkalfas.lorempicsum.discovery.data.PhotoItemDto

internal class DiscoveryFragment : CoreFragment<DiscoveryFragmentBinding>(R.layout.discovery_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflaterProvider = LayoutInflaterProvider()
        val bindingProvider = DataBindingProvider()
        val discoveryRecyclerAdapter = DiscoveryRecyclerAdapter(inflaterProvider, bindingProvider)
        binding.discoveryWhatsNewRecycler.adapter = discoveryRecyclerAdapter
        discoveryRecyclerAdapter.items = listOf(
            PhotoItemDto(
                "Name 237",
                "ProfileName 237",
                "https://i.pravatar.cc/150?u=237",
                "https://picsum.photos/id/237/350/350"
            ),
            PhotoItemDto(
                "Name 238",
                "ProfileName 238",
                "https://i.pravatar.cc/150?u=238",
                "https://picsum.photos/id/238/350/350"
            ),
            PhotoItemDto(
                "Name 239",
                "ProfileName 239",
                "https://i.pravatar.cc/150?u=239",
                "https://picsum.photos/id/239/350/350"
            ),
            PhotoItemDto(
                "Name 240",
                "ProfileName 240",
                "https://i.pravatar.cc/150?u=240",
                "https://picsum.photos/id/240/350/350"
            ),
            PhotoItemDto(
                "Name 241",
                "ProfileName 241",
                "https://i.pravatar.cc/150?u=241",
                "https://picsum.photos/id/241/350/350"
            )
        )
    }
}
