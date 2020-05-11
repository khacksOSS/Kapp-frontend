package com.khacks.kapp_frontend.announcementDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.khacks.kapp_frontend.util.A_AUTHOR
import com.khacks.kapp_frontend.util.A_DESCRIPTION
import com.khacks.kapp_frontend.util.A_TIME
import com.khacks.kapp_frontend.util.A_TITLE
import com.khacks.kapp_frontend.R.drawable
import com.khacks.kapp_frontend.R.layout
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_author_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_desc_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_time_content
import kotlinx.android.synthetic.main.activity_announcement_detail.tv_title_content

class AnnouncementDetail : AppCompatActivity() {

  private lateinit var title: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_announcement_detail)
    customActionBar()

    tv_author_content.text = intent.getStringExtra(A_AUTHOR)
    tv_time_content.text = intent.getStringExtra(A_TIME)
    tv_title_content.text = intent.getStringExtra(A_TITLE)
    tv_desc_content.text = intent.getStringExtra(A_DESCRIPTION)
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
