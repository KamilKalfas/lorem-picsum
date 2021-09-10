package com.kkalfas.lorempicsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kkalfas.lorempicsum.welcome.WelcomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, WelcomeFragment())
                .commit()
    }
}
