package com.khacks.kapp_frontend.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.khacks.kapp_frontend.announcement.AnnouncementsActivity
import com.khacks.kapp_frontend.R.layout
import com.khacks.kapp_frontend.adapters.DashboardAnnRecAdapter
import com.khacks.kapp_frontend.announcement.AnnouncementsViewModel
import com.khacks.kapp_frontend.announcementDetail.AnnouncementDetail
import com.khacks.kapp_frontend.dataClass.Article
import com.khacks.kapp_frontend.util.A_AUTHOR
import com.khacks.kapp_frontend.util.A_DESCRIPTION
import com.khacks.kapp_frontend.util.A_TIME
import com.khacks.kapp_frontend.util.A_TITLE
import kotlinx.android.synthetic.main.fragment_dashboard.view.bt_announcements
import kotlinx.android.synthetic.main.fragment_dashboard.view.dash_recycler_view

class DashboardFragment : Fragment() {

  private lateinit var adapter: DashboardAnnRecAdapter
  var announcementsViewModel: AnnouncementsViewModel? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    var view: View = inflater.inflate(layout.fragment_dashboard, container, false)

    view.bt_announcements.setOnClickListener {
      startActivity(Intent(activity, AnnouncementsActivity::class.java))
    }

    announcementsViewModel = ViewModelProviders.of(this).get(AnnouncementsViewModel::class.java)
    announcementsViewModel!!.getModelAnn()
    initRecyclerView(view)
    announcementsViewModel!!.annLiveData.observe(viewLifecycleOwner, Observer {
      adapter.setAnnouncements(it)
    })
    return view
  }

  private fun initRecyclerView(view: View) {
    view.dash_recycler_view.layoutManager =
      LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    view.dash_recycler_view.setHasFixedSize(true)
    adapter = DashboardAnnRecAdapter()
    view.dash_recycler_view.adapter = adapter
    adapter.setOnClickListener(object : DashboardAnnRecAdapter.OnItemClickListener {
      override fun onItemClickListener(announcement: Article) {
        val intent = Intent(activity, AnnouncementDetail::class.java)
        intent.putExtra(A_TITLE, announcement.title)
        intent.putExtra(A_TIME, announcement.time)
        intent.putExtra(A_AUTHOR, announcement.author)
        intent.putExtra(A_DESCRIPTION, announcement.description)
        startActivity(intent)
      }
    })
  }

}