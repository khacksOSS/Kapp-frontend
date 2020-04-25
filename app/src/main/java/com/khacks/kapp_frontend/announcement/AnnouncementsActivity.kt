package com.khacks.kapp_frontend.announcement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.khacks.kapp_frontend.R.drawable
import com.khacks.kapp_frontend.R.layout

class AnnouncementsActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_announcements)

    customActionBar()
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = "Announcements"
    actionBar?.elevation = 0F
    actionBar?.setHomeAsUpIndicator(drawable.back_button)
    actionBar?.setDisplayHomeAsUpEnabled(true)
  }
}
