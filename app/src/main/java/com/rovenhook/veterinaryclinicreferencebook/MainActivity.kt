package com.rovenhook.veterinaryclinicreferencebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rovenhook.veterinaryclinicreferencebook.databinding.ActivityMainBinding
import com.rovenhook.veterinaryclinicreferencebook.screens.AnimalsFragment
import com.rovenhook.veterinaryclinicreferencebook.screens.CatsFragment
import com.rovenhook.veterinaryclinicreferencebook.screens.DogsFragment
import com.rovenhook.veterinaryclinicreferencebook.viewmodels.ReferenceBookViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationMenuSetup()

        val viewModel: ReferenceBookViewModel =
            ViewModelProvider(this).get(ReferenceBookViewModel::class.java)

    }

    fun navigationMenuSetup() {
        theme.applyStyle(R.style.Theme_VeterinaryClinicReferenceBook_Second, true)
        window.statusBarColor = resources.getColor(R.color.cyan_100_dark)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, CatsFragment(this))
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener { selectedMenuItem ->
            val selectedFragment = when (selectedMenuItem.itemId) {
                R.id.nav_cat -> {
                    theme.applyStyle(R.style.Theme_VeterinaryClinicReferenceBook_Second, true)
                    window.statusBarColor = resources.getColor(R.color.cyan_100_dark)
                    CatsFragment(this)
                }
                R.id.nav_dog -> {
                    theme.applyStyle(R.style.Theme_VeterinaryClinicReferenceBook_Third, true)
                    window.statusBarColor = resources.getColor(R.color.deep_orange_100_dark)
                    DogsFragment(this)
                }
                else -> {
                    theme.applyStyle(R.style.Theme_VeterinaryClinicReferenceBook_Fourth, true)
                    window.statusBarColor = resources.getColor(R.color.light_green_100_dark)
                    AnimalsFragment(this)
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, selectedFragment)
                .commit()

            true
        }
    }
}