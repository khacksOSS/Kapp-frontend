package com.khacks.kapp_frontend.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.khacks.kapp_frontend.announcement.Announcement
import com.khacks.kapp_frontend.adapters.AnnouncementRecAdapter
import com.khacks.kapp_frontend.announcement.AnnouncementsActivity
import com.khacks.kapp_frontend.R.layout
import com.khacks.kapp_frontend.adapters.AnnouncementRecAdapter.OnDashAnnouncementClickListener
import com.khacks.kapp_frontend.announcementDetail.AnnouncementDetail
import com.khacks.kapp_frontend.networking.GetAnnouncementService
import com.khacks.kapp_frontend.networking.Message
import com.khacks.kapp_frontend.networking.RetrofitClientInstance
import com.khacks.kapp_frontend.networking.ServerResponse
import kotlinx.android.synthetic.main.fragment_dashboard.view.bt_announcements
import kotlinx.android.synthetic.main.fragment_dashboard.view.dash_recycler_view
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment(), OnDashAnnouncementClickListener {

  private lateinit var adapter : AnnouncementRecAdapter
  val dataSource: ArrayList<Announcement> = ArrayList()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    var view: View = inflater.inflate(layout.fragment_dashboard, container, false)

    view.bt_announcements.setOnClickListener {
      startActivity(Intent(activity, AnnouncementsActivity::class.java))
    }

    val service = RetrofitClientInstance.retrofitInstance?.create(GetAnnouncementService::class.java)
    val call = service?.getAllAnnouncements()
    call?.enqueue(object : Callback<ServerResponse> {
      override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
        Toast.makeText(activity, "Error reading", Toast.LENGTH_SHORT).show()
      }

      override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
        val body = response?.body()
        val announcements : List<Message>? = body?.message

        for (a in announcements.orEmpty()) {
          dataSource.add(
            Announcement(
              a.tags,
              a._id,
              a.title,
              a.description,
              a.author,
              a.time,
              a.__v
            )
          )
        }
        view.dash_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = AnnouncementRecAdapter(this@DashboardFragment)
        view.dash_recycler_view.adapter = adapter
        adapter.submitItems(dataSource.toList())
      }
    })
    return view
  }

  override fun onItemClick(item: Announcement, position: Int) {
    val intent = Intent(activity, AnnouncementDetail::class.java)
    intent.putExtra("title", item.title)
    intent.putExtra("time", item.time)
    intent.putExtra("author", item.author)
    intent.putExtra("desc", item.description)
    startActivity(intent)
  }
}