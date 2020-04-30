package com.khacks.kapp_frontend.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khacks.kapp_frontend.dataClass.Announcement
import com.khacks.kapp_frontend.R.layout
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_date_dash
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_tag_dash
import kotlinx.android.synthetic.main.announcement_dashboard_item.view.tv_title_dash

class AnnouncementRecAdapter(var clickListener: OnDashAnnouncementClickListener) :
  RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var announcementList: List<Announcement> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return AnnouncementViewHolder(
      LayoutInflater.from(parent.context).inflate(
        layout.announcement_dashboard_item,
        parent,
        false
      )
    )
  }

  override fun getItemCount(): Int {
    return announcementList.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    when (holder) {
      is AnnouncementViewHolder -> {
        holder.bind(announcementList.get(position), clickListener)
      }
    }
  }

  fun submitItems(items: List<Announcement>) {
    announcementList = items
  }

  class AnnouncementViewHolder constructor(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView) {
    val date = itemView.tv_date_dash
    val title = itemView.tv_title_dash
    val tag = itemView.tv_tag_dash

    fun bind(announcement: Announcement, action: OnDashAnnouncementClickListener) {
      date.text = announcement.time
      title.text = announcement.title
      tag.text = announcement.tags.get(0)

      itemView.setOnClickListener {
        action.onItemClick(announcement, adapterPosition)
      }
    }
  }

  interface OnDashAnnouncementClickListener {
    fun onItemClick(item: Announcement, position: Int)
  }
}