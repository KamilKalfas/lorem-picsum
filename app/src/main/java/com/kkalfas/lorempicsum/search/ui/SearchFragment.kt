package com.kkalfas.lorempicsum.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.common.domain.model.PhotoCardInfo

internal class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.search_compose_view).setContent {
                SearchScreen(
                    viewModel = viewModel,
                    onPhotoItemClicked = {
                        navigateToPhotoDetails(item = it)
                    },
                    onSeeMoreClicked = {
                        // TODO add load more
                    }
                )
            }
        }
    }

    private fun navigateToPhotoDetails(item: PhotoCardInfo) {
        val action = SearchFragmentDirections.actionSearchFragmentToPhotoFragment(item)
        findNavController().navigate(action)
    }
}
