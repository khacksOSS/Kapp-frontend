package com.khacks.kapp_frontend.announcement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.khacks.kapp_frontend.R.drawable
import com.khacks.kapp_frontend.R.layout
import com.khacks.kapp_frontend.adapters.AnnouncementARecAdapter
import kotlinx.android.synthetic.main.activity_announcements.announcements_recycler_view

class AnnouncementsActivity : AppCompatActivity() {

  private lateinit var adapter : AnnouncementARecAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_announcements)

    customActionBar()

    initRecyclerView()
    addDataSet()
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = "Announcements"
    actionBar?.elevation = 0F
    actionBar?.setHomeAsUpIndicator(drawable.back_button)
    actionBar?.setDisplayHomeAsUpEnabled(true)
  }

  private fun initRecyclerView() {
    announcements_recycler_view.layoutManager = LinearLayoutManager(this)
    adapter = AnnouncementARecAdapter()
    announcements_recycler_view.adapter = adapter
  }

  private fun addDataSet() {
    val dataSource = DataSource.createDataSet()
    adapter.submitItems(dataSource)
  }
}
