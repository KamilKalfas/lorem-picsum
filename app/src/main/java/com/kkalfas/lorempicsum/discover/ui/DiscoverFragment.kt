package com.kkalfas.lorempicsum.discover.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.DataBindingProvider
import com.kkalfas.lorempicsum.core.LayoutInflaterProvider
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.DiscoverFragmentBinding
import com.kkalfas.lorempicsum.discover.data.PhotoItemDto

private const val SPAN_COUNT = 2

internal class DiscoverFragment : CoreFragment<DiscoverFragmentBinding>(R.layout.discover_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflaterProvider = LayoutInflaterProvider()
        val bindingProvider = DataBindingProvider()
        val whatsNewTodayAdapter = WhatsNewAdapter(inflaterProvider, bindingProvider)
        binding.discoverWhatsNewRecycler.adapter = whatsNewTodayAdapter
        whatsNewTodayAdapter.items = Mock.feed

        with(binding.discoverBrowseAllRecycler) {
            val browseAllAdapter = BrowseAllAdapter(inflaterProvider, bindingProvider)
            layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
            browseAllAdapter.items = Mock.feed
            adapter = browseAllAdapter
        }
    }
}

internal object Mock {
    val feed = listOf(
        PhotoItemDto(
            "Name 235",
            "ProfileName 235",
            "https://i.pravatar.cc/150?u=235",
            "https://picsum.photos/id/235/350/350"
        ),
        PhotoItemDto(
            "Name 236",
            "ProfileName 236",
            "https://i.pravatar.cc/150?u=236",
            "https://picsum.photos/id/236/350/350"
        ),
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
        ),
        PhotoItemDto(
            "Name 242",
            "ProfileName 242",
            "https://i.pravatar.cc/150?u=242",
            "https://picsum.photos/id/242/350/350"
        ),
        PhotoItemDto(
            "Name 243",
            "ProfileName 243",
            "https://i.pravatar.cc/150?u=243",
            "https://picsum.photos/id/243/350/350"
        ),
        PhotoItemDto(
            "Name 244",
            "ProfileName 244",
            "https://i.pravatar.cc/150?u=244",
            "https://picsum.photos/id/244/350/350"
        )
    )
}
