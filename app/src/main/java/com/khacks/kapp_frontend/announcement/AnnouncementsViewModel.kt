package com.khacks.kapp_frontend.announcement

import retrofit2.Callback
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khacks.kapp_frontend.repositories.AnnouncementRepository
import com.khacks.kapp_frontend.dataClass.Article
import com.khacks.kapp_frontend.dataClass.ServerResponse
import retrofit2.Call
import retrofit2.Response

class AnnouncementsViewModel : ViewModel() {
  var annLiveData: MutableLiveData<List<Article>> = MutableLiveData()
  var stringData: MutableLiveData<String> = MutableLiveData()

  fun getModelAnn() {
    AnnouncementRepository().getInstance()!!.getAnn().enqueue(object : Callback<ServerResponse> {
      override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
        stringData.value = "err"
      }

      override fun onResponse(call: Call<ServerResponse>, response: Response<ServerResponse>) {
        annLiveData.value = response.body()!!.message.articles
      }
    })
  }
}

