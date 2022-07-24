package com.kkalfas.lorempicsum.signup.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kkalfas.lorempicsum.R

internal class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.signup_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.signup_compose_view).setContent {
                SignUpScreen(
                    navigateToHome = { navigateToHome() }
                )
            }
        }
    }

    private fun navigateToHome() {
        val action = SignUpFragmentDirections.actionSignUpFragmentToDiscoverFragment()
        findNavController().navigate(action)
    }
}
