package com.khacks.kapp_frontend.repositories

import com.khacks.kapp_frontend.dataClass.ServerResponse
import com.khacks.kapp_frontend.networking.AnnouncementAPI
import com.khacks.kapp_frontend.networking.RetrofitClientInstance
import retrofit2.Call

class AnnouncementRepository {

  private var announcementRepository: AnnouncementRepository? = null
  private var announcementAPI: AnnouncementAPI? = null
  private var retrofitClientInstance: RetrofitClientInstance? = null

  init {
    retrofitClientInstance = RetrofitClientInstance()
    announcementAPI = retrofitClientInstance?.getAPI()
  }

  fun getInstance(): AnnouncementRepository? {
    if (announcementRepository == null) {
      announcementRepository =
        AnnouncementRepository()
    }
    return announcementRepository
  }

  fun getAnn(): Call<ServerResponse> {
    return announcementAPI!!.getAnnouncementList()
  }

}