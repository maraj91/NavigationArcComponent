package com.maraj.android.androidnavigationcontroller.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.maraj.android.androidnavigationcontroller.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this@MainActivity,
            R.id.my_nav_host_fragment
        )
        setSupportActionBar(toolbar)
        val toggle = object : ActionBarDrawerToggle(
            this, drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {}

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        setupNavigationDrawer()
        nav_view.setNavigationItemSelectedListener(this)

    }

    private fun setupNavigationDrawer() {
        val appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)
        setupWithNavController(toolbar, navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this,
            R.id.my_nav_host_fragment
        ).navigateUp() || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                navController.navigate(R.id.action_homeFragment_to_profileFragment)
            }
            R.id.nav_settings -> {
                navController.navigate(R.id.action_homeFragment_to_settingFragment2)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
