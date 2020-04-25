package com.khacks.kapp_frontend.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.announcement.Announcement
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_date
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_number
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_tag
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_title

class AnnouncementARecAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var announcementList : List<Announcement> = ArrayList()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return AnnouncementViewHolder(
      LayoutInflater.from(parent.context).inflate(
        R.layout.announcement_item,
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
        holder.bind(announcementList.get(position))
      }
    }
  }

  fun submitItems(items: List<Announcement>) {
    announcementList = items
  }

  class AnnouncementViewHolder constructor(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView) {
    val date = itemView.tv_a_date
    val title = itemView.tv_a_title
    val tag = itemView.tv_a_tag
    val number = itemView.tv_a_number

    fun bind(announcement: Announcement) {
      date.text = announcement.date
      title.text = announcement.title
      tag.text = announcement.tag
      number.text = (adapterPosition + 1).toString()
    }
  }

}