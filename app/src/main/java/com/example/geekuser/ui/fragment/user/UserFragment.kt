package com.example.geekuser.ui.fragment.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.geekuser.R
import com.example.geekuser.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToggle()
    }

    private fun setupToggle() {
        binding.imageList.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            toggle = ActionBarDrawerToggle(requireActivity(),
                binding.drawerLayout,
                R.string.app_name,
                R.string.hello)
            binding.drawerLayout.addDrawerListener(toggle)
            toggle.syncState()
            binding.navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> Toast.makeText(requireContext(), "toast", Toast.LENGTH_SHORT)
                        .show()
                    R.id.settings -> Toast.makeText(requireContext(), "toast", Toast.LENGTH_SHORT)
                        .show()
                }
                true
            }
        }
    }
}