package com.khacks.kapp_frontend.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.khacks.kapp_frontend.AnnouncementsActivity
import com.khacks.kapp_frontend.R.layout
import kotlinx.android.synthetic.main.fragment_dashboard.view.bt_announcements

class DashboardFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    var view: View = inflater.inflate(layout.fragment_dashboard, container, false)

    view.bt_announcements.setOnClickListener {
      startActivity(Intent(activity, AnnouncementsActivity::class.java))
    }
    return view
  }
}