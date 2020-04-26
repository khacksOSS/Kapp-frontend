package com.khacks.kapp_frontend.announcement

data class Announcement(
  var tags: List<String>,
  var id: String,
  var title: String,
  var description: String,
  var author: String,
  var time: String,
  var v: String
)