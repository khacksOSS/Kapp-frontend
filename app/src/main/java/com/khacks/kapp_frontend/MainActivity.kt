package com.khacks.kapp_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.action_bar_title
import kotlinx.android.synthetic.main.activity_main.bottom_navigation

class MainActivity : AppCompatActivity() {

  lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //bottom navigation controller
    navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    NavigationUI.setupWithNavController(bottom_navigation, navController)

    action_bar_title.text = "Welcome, Joel"
  }
}
