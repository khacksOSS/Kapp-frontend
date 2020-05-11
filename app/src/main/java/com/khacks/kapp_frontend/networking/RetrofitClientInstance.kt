package com.khacks.kapp_frontend.networking

import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
  private val BASE_URL = "https://khacksappapi01011999.herokuapp.com/"
  private var announcementAPI: AnnouncementAPI? = null

  init {
    val retrofit = Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    announcementAPI = retrofit.create(AnnouncementAPI::class.java)
  }

  fun getAPI(): AnnouncementAPI {
    return announcementAPI!!
  }
}