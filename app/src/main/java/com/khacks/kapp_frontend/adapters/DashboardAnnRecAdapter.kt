package com.khacks.kapp_frontend.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.dataClass.Announcement
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_date_dash
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_tag_dash
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_title_dash

class DashboardAnnRecAdapter : RecyclerView.Adapter<DashboardAnnRecAdapter.AnnViewHolder>() {

  private var announcements : List<Announcement> = ArrayList()
  private var listener : OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnViewHolder {
    val itemView : View = LayoutInflater.from(parent.context)
      .inflate(R.layout.announcement_dashboard_item, parent, false)
    return AnnViewHolder(itemView)
  }

  override fun getItemCount(): Int {
    return announcements.size
  }

  override fun onBindViewHolder(holder: AnnViewHolder, position: Int) {
    val currentAnnouncement : Announcement = announcements.get(position)
    holder.date.text = currentAnnouncement.time
    holder.title.text = currentAnnouncement.title
    holder.tag.text = currentAnnouncement.tags.get(0)
  }

  fun setAnnouncements(announcements : List<Announcement>) {
    this.announcements = announcements
    notifyDataSetChanged()
  }

  inner class AnnViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    init {
      itemView.setOnClickListener {
        val position = adapterPosition
        if (listener != null && position != RecyclerView.NO_POSITION) {
          listener!!.onItemClickListener(announcements.get(position))
        }
      }
    }

    var date : TextView = itemView.tv_date_dash
    var title : TextView = itemView.tv_title_dash
    var tag : TextView = itemView.tv_tag_dash
  }

  interface OnItemClickListener {
    fun onItemClickListener(announcement: Announcement)
  }

  fun setOnClickListener(listener: OnItemClickListener) {
    this.listener = listener
  }
}