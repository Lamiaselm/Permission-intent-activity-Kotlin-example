package com.example.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav = findNavController(this,R.id.nav_host)
        setupActionBarWithNavController(nav)

    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(this,R.id.nav_host)
        return navController.navigateUp()
    }
}