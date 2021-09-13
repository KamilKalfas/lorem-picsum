package com.kkalfas.lorempicsum.welcome.signup

import android.os.Bundle
import android.view.View
import com.kkalfas.lorempicsum.R
import com.kkalfas.lorempicsum.core.ui.CoreFragment
import com.kkalfas.lorempicsum.databinding.SignupFragmentBinding

internal class SignUpFragment : CoreFragment<SignupFragmentBinding>(R.layout.signup_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.signupToolbar) {
            setNavigationIcon(R.drawable.ic_nav_back)
            setNavigationOnClickListener {
                // use navigation to go back to welcome_fragment
            }
        }
    }
}
