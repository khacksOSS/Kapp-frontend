package com.khacks.kapp_frontend.networking

data class Article(
  var tags : List<String>,
  var _id : String,
  var title: String,
  var description: String,
  var author: String,
  var time: String,
  var __v: String
)