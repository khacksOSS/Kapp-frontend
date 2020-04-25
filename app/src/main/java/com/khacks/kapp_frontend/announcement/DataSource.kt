package com.khacks.kapp_frontend.announcement

import com.khacks.kapp_frontend.announcement.Announcement

class DataSource{
  companion object{
    fun createDataSet(): ArrayList<Announcement>{
      val list = ArrayList<Announcement>()
      list.add(
        Announcement(
          "Tue, Apr 21, 2020",
          "Exams postponed till further notice",
          "Exams"
        )
      )
      list.add(
        Announcement(
          "Tue, Apr 21, 2020",
          "Exams postponed till further notice",
          "Exams"
        )
      )
      return list
    }
  }
}