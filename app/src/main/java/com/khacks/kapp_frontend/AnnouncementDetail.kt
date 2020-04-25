package com.khacks.kapp_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.khacks.kapp_frontend.R.drawable
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_author
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_author_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_desc_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_time
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_time_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_title_content

class AnnouncementDetail : AppCompatActivity() {

  private lateinit var title: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_announcement_detail)
    customActionBar()

    tv_author_content.text = intent.getStringExtra("author")
    tv_time_content.text = intent.getStringExtra("time")
    tv_title_content.text = intent.getStringExtra("title")
    tv_desc_content.text = intent.getStringExtra("desc")
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = intent.getStringExtra("title")
    actionBar?.elevation = 0F
    actionBar?.setHomeAsUpIndicator(drawable.close)
    actionBar?.setDisplayHomeAsUpEnabled(true)
  }
}
