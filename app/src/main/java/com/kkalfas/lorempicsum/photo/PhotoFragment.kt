package com.kkalfas.lorempicsum.photo

import android.os.Bundle
import android.view.View
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.PhotoFragmentBinding

internal class PhotoFragment : CoreFragment<PhotoFragmentBinding>(R.layout.photo_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.toolbar) {
            setNavigationIcon(R.drawable.ic_close)
            setNavigationOnClickListener {
                // use navigation to go back to discover_fragment
            }
        }
    }
}
