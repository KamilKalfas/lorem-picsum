package com.kkalfas.lorempicsum.photo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kkalfas.lorempicsum.R

internal class PhotoFragment : Fragment() {

    private val args: PhotoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.photo_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.photo_compose_view).setContent {
                PhotoScreen(
                    photo = args.photo,
                    onBackClick = {
                        findNavController().navigateUp()
                    }
                )
            }
        }
    }
}
