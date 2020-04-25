package com.khacks.kapp_frontend.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.khacks.kapp_frontend.adapters.AnnouncementRecAdapter
import com.khacks.kapp_frontend.announcement.DataSource
import com.khacks.kapp_frontend.announcement.AnnouncementsActivity
import com.khacks.kapp_frontend.R.layout
import kotlinx.android.synthetic.main.fragment_dashboard.view.bt_announcements
import kotlinx.android.synthetic.main.fragment_dashboard.view.dash_recycler_view

class DashboardFragment : Fragment() {

  private lateinit var adapter : AnnouncementRecAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    var view: View = inflater.inflate(layout.fragment_dashboard, container, false)

    view.bt_announcements.setOnClickListener {
      startActivity(Intent(activity, AnnouncementsActivity::class.java))
    }

    view.dash_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    adapter = AnnouncementRecAdapter()
    view.dash_recycler_view.adapter = adapter
    addDataSet()
    return view
  }

  private fun addDataSet() {
    val dataSource = DataSource.createDataSet()
    adapter.submitItems(dataSource)
  }
}