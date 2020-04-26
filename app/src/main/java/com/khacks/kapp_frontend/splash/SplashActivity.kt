package com.khacks.kapp_frontend.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.welcome.WelcomeActivity

class SplashActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    customActionBar()
    delayFunction()
  }

  private fun delayFunction() {
    Handler().postDelayed({
      startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
      finish()
    }, 4000)
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.hide()
  }
}
