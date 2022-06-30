package com.kkalfas.lorempicsum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kkalfas.lorempicsum.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private var _binding: MainActivityBinding? = null
    internal val binding get() = _binding!!

    private val flowsWithBottomBarDestinationIds = setOf(R.id.discoverFragment, R.id.searchFragment, R.id.chatsFragment, R.id.profileFragment)
    private val navController: NavController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return if (navController.graph.id == R.id.home) navController.navigateUp()
        else super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
