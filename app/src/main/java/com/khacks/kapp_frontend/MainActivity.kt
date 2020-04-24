package com.khacks.kapp_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import kotlinx.android.synthetic.main.custom_action_bar.view.action_bar_title

class MainActivity : AppCompatActivity() {

  lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    customActionBar()

    //bottom navigation controller
    navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    NavigationUI.setupWithNavController(bottom_navigation, navController)
  }

  //function to modify actionbar
  private fun customActionBar() {
    var toolbar: Toolbar = findViewById(R.id.main_custom_action_bar) as Toolbar
    setSupportActionBar(toolbar)
    actionBar?.setDisplayHomeAsUpEnabled(true)
    //here the username will replace 'Joel'
    toolbar.action_bar_title.text = "Welcome, Joel"
  }
}
