package com.khacks.kapp_frontend.announcement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.khacks.kapp_frontend.util.A_AUTHOR
import com.khacks.kapp_frontend.util.A_DESCRIPTION
import com.khacks.kapp_frontend.util.A_TIME
import com.khacks.kapp_frontend.util.A_TITLE
import com.khacks.kapp_frontend.announcementDetail.AnnouncementDetail
import com.khacks.kapp_frontend.networking.GetAnnouncementService
import com.khacks.kapp_frontend.R.drawable
import com.khacks.kapp_frontend.R.layout
import com.khacks.kapp_frontend.adapters.AnnActivityRecAdapter
import com.khacks.kapp_frontend.networking.RetrofitClientInstance
import com.khacks.kapp_frontend.dataClass.ServerResponse
import com.khacks.kapp_frontend.dataClass.Announcement
import com.khacks.kapp_frontend.dataClass.Article
import kotlinx.android.synthetic.main.activity_announcements.announcements_recycler_view
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnnouncementsActivity : AppCompatActivity() {

  private lateinit var adapter : AnnActivityRecAdapter
  val dataSource: ArrayList<Announcement> = ArrayList()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_announcements)

    customActionBar()

    val service = RetrofitClientInstance.retrofitInstance?.create(GetAnnouncementService::class.java)
    val call = service?.getAllAnnouncements()
    call?.enqueue(object : Callback<ServerResponse> {
      override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
        Toast.makeText(applicationContext, "Error reading", Toast.LENGTH_SHORT).show()
      }

      override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
        val body = response.body()
        val announcements : List<Article>? = body?.message!!.articles

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
        initRecyclerView()
        adapter.setAnnouncements(dataSource)
      }
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
    adapter.setOnClickListener(object : AnnActivityRecAdapter.OnItemClickListener {
      override fun onItemClickListener(announcement: Announcement) {
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
