package com.khacks.kapp_frontend.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.khacks.kapp_frontend.MainActivity
import com.khacks.kapp_frontend.R
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_signin)
    customActionBar()

    bt_sigin.setOnClickListener {
      startActivity(Intent(this@SignInActivity, MainActivity::class.java))
    }
  }

  //function to modify actionbar
  private fun customActionBar() {
    val actionBar: ActionBar? = supportActionBar
    actionBar?.title = "Sign In"
    actionBar?.elevation = 0F
    actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
    actionBar?.setDisplayHomeAsUpEnabled(true)
  }
}
