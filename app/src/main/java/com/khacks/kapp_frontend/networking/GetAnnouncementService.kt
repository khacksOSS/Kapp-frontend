package com.khacks.kapp_frontend.networking

import retrofit2.Call
import retrofit2.http.GET

interface GetAnnouncementService {
  @GET("articles")
  fun getAllAnnouncements(): Call<ServerResponse>
}