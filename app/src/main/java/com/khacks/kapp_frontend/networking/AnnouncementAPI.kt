package com.khacks.kapp_frontend.networking

import com.khacks.kapp_frontend.dataClass.ServerResponse
import retrofit2.Call
import retrofit2.http.GET

interface AnnouncementAPI {
  @GET("articles")
  fun getAnnouncementList(): Call<ServerResponse>
}