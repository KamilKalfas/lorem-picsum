package com.kkalfas.lorempicsum.profile.ui

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

internal class ProfileFragment : Fragment() {
    private val viewModel by viewModels<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.profile_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.profile_compose_view).setContent {
                ProfileScreen(
                    viewModel = viewModel,
                    onPhotoItemClicked = { item -> navigateToPhotoDetails(item) }
                )
                LaunchedEffect(Unit) {
                    viewModel.onGetProfile()
                }
            }
        }
    }

    private fun navigateToPhotoDetails(item: PhotoCardInfo) {
        val action =
            ProfileFragmentDirections.actionProfileFragmentToPhotoFragment(item)
        findNavController().navigate(action)
    }
}
