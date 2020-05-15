package com.khacks.kapp_frontend.announcement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.khacks.kapp_frontend.util.A_AUTHOR
import com.khacks.kapp_frontend.util.A_DESCRIPTION
import com.khacks.kapp_frontend.util.A_TIME
import com.khacks.kapp_frontend.util.A_TITLE
import com.khacks.kapp_frontend.announcementDetail.AnnouncementDetail
import com.khacks.kapp_frontend.R.drawable
import com.khacks.kapp_frontend.R.layout
import com.khacks.kapp_frontend.adapters.AnnActivityRecAdapter
import com.khacks.kapp_frontend.adapters.RecyclerViewDecoration
import com.khacks.kapp_frontend.dataClass.Article
import kotlinx.android.synthetic.main.activity_announcements.announcements_recycler_view

class AnnouncementsActivity : AppCompatActivity() {

  private lateinit var adapter: AnnActivityRecAdapter
  var announcementsViewModel: AnnouncementsViewModel? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_announcements)
    customActionBar()

    announcementsViewModel = ViewModelProviders.of(this).get(AnnouncementsViewModel::class.java)
    announcementsViewModel!!.getModelAnn()
    initRecyclerView()
    announcementsViewModel!!.annLiveData.observe(this, Observer {
      adapter.setAnnouncements(it)
    })
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
    announcements_recycler_view.setHasFixedSize(true)
    adapter = AnnActivityRecAdapter()
    announcements_recycler_view.adapter = adapter
    val recyclerViewDecoration = RecyclerViewDecoration(30)
    announcements_recycler_view.addItemDecoration(recyclerViewDecoration)
    adapter.setOnClickListener(object : AnnActivityRecAdapter.OnItemClickListener {
      override fun onItemClickListener(announcement: Article) {
        val intent = Intent(this@AnnouncementsActivity, AnnouncementDetail::class.java)
        intent.putExtra(A_TITLE, announcement.title)
        intent.putExtra(A_TIME, announcement.time)
        intent.putExtra(A_AUTHOR, announcement.author)
        intent.putExtra(A_DESCRIPTION, announcement.description)
        startActivity(intent)
      }
    })
  }
}
