package com.kkalfas.lorempicsum.welcome.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kkalfas.lorempicsum.R

internal class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.welcome_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.welcome_compose_view).setContent {
                WelcomeScreen(
                    onSignupClick = { navigateToSignUp() },
                    onLoginClick = { navigateToLogin() }
                )
            }
        }
    }

    private fun navigateToSignUp() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToSignUpFragment()
        findNavController().navigate(action)
    }

    private fun navigateToLogin() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}
