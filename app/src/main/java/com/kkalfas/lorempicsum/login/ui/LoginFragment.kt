package com.kkalfas.lorempicsum.login.ui

import android.os.Bundle
import android.view.View
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.LoginFragmentBinding

internal class LoginFragment : CoreFragment<LoginFragmentBinding>(R.layout.login_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.loginToolbar) {
            setNavigationIcon(R.drawable.ic_nav_back)
            setNavigationOnClickListener {
                // use navigation to go back to welcome_fragment
            }
        }
    }
}
