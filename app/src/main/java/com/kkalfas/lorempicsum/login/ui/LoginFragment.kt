package com.kkalfas.lorempicsum.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kkalfas.lorempicsum.R

internal class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.login_compose_view).setContent {
                LoginScreen(
                    viewModel = viewModel,
                    navigateToHome = { navigateToHome() }
                )
            }
        }
    }

    private fun navigateToHome() {
        val action = LoginFragmentDirections.actionLoginFragmentToDiscoverFragment()
        findNavController().navigate(action)
    }
}
