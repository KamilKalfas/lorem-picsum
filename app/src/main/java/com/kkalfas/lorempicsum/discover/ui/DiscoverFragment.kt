package com.kkalfas.lorempicsum.discover.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class DiscoverFragment : Fragment() {
    private val viewModel by viewModels<DiscoverViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.discover_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.discover_compose_view).setContent {
                DiscoverScreen(
                    viewModel = viewModel,
                    onPhotoItemClicked = {
                        navigateToPhotoDetails(item = it)
                    }
                )
                LaunchedEffect(Unit) {
                    viewModel.onGetWhatsNewFeed()
                    viewModel.onGetBrowseAllFeed()
                }
            }
        }
    }

    private fun navigateToPhotoDetails(item: PhotoCardInfo) {
        val action = DiscoverFragmentDirections.actionDiscoverFragmentToPhotoFragment(item)
        findNavController().navigate(action)
    }
}
