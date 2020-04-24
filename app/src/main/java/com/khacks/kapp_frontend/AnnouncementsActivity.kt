package com.khacks.kapp_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class AnnouncementsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_announcements)

    customActionBar()
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = "Announcements"
    actionBar?.elevation = 0F
    actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
    actionBar?.setDisplayHomeAsUpEnabled(true)
  }
}
