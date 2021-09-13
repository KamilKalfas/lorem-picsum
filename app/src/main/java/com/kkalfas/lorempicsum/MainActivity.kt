package com.kkalfas.lorempicsum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kkalfas.lorempicsum.discover.ui.DiscoveryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DiscoveryFragment())
            .commit()
    }
}
