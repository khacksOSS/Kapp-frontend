package com.khacks.kapp_frontend.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.adapters.AnnActivityRecAdapter.AnnViewHolder
import com.khacks.kapp_frontend.dataClass.Article
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_date
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_tag
import kotlinx.android.synthetic.main.announcement_item.view.tv_a_title

class AnnActivityRecAdapter : RecyclerView.Adapter<AnnViewHolder>() {

  private var announcements: List<Article> = ArrayList()
  private var listener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnViewHolder {
    val itemView: View = LayoutInflater.from(parent.context)
      .inflate(R.layout.announcement_item, parent, false)
    return AnnViewHolder(itemView)
  }

  override fun getItemCount(): Int {
    return announcements.size
  }

  override fun onBindViewHolder(holder: AnnViewHolder, position: Int) {
    val currentAnnouncement: Article = announcements.get(position)
    holder.date.text = currentAnnouncement.time
    holder.title.text = currentAnnouncement.title
    holder.tag.text = currentAnnouncement.tags.get(0)
  }

  fun setAnnouncements(announcements: List<Article>) {
    this.announcements = announcements
    notifyDataSetChanged()
  }

  inner class AnnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
      itemView.setOnClickListener {
        val position = adapterPosition
        if (listener != null && position != RecyclerView.NO_POSITION) {
          listener!!.onItemClickListener(announcements.get(position))
        }
      }
    }

    var date: TextView = itemView.tv_a_date
    var title: TextView = itemView.tv_a_title
    var tag: TextView = itemView.tv_a_tag
  }

  interface OnItemClickListener {
    fun onItemClickListener(announcement: Article)
  }

  fun setOnClickListener(listener: OnItemClickListener) {
    this.listener = listener
  }
}