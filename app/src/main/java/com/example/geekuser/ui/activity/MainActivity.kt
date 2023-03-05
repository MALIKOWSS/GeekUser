package com.example.geekuser.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.geekuser.App
import com.example.geekuser.R
import com.example.geekuser.databinding.ActivityMainBinding
import com.example.geekuser.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isShowFirstScreen()
    }

    private fun isShowFirstScreen() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        when (PreferenceHelper.showOnBoard) {
            true -> {
                navController.navigate(R.id.userFragment)
                navController.popBackStack()
            }
            else -> {
                navController.navigate(R.id.signUpFragment)
            }
        }
    }
}