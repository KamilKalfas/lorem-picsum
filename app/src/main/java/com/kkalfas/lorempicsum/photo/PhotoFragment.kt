package com.kkalfas.lorempicsum.photo

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.PhotoFragmentBinding

internal class PhotoFragment : CoreFragment<PhotoFragmentBinding>(R.layout.photo_fragment) {

    private val args: PhotoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = args.photoDto
        with(binding.toolbar) {
            setNavigationIcon(R.drawable.ic_close)
            setNavigationOnClickListener {
                view.findNavController().navigateUp()
            }
        }
    }
}
