package com.example.imdb_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // get fragments
        val searchFragment: Fragment = SearchFragment()
        val homeFragment: Fragment = HomeFragment()
        val playFragment: Fragment = PlayFragment()
        val profileFragment: Fragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        // get navigation view and set on click listener
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.search -> setCurrentFragment(searchFragment)
                R.id.play -> setCurrentFragment(playFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main_fragment, fragment)
            commit()
        }
    }
}