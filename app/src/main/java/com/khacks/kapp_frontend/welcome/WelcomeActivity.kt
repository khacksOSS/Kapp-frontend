package com.khacks.kapp_frontend.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.adapters.WelcomeSlideAdapter
import com.khacks.kapp_frontend.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private val welcomeSlideAdapter =
        WelcomeSlideAdapter(
            listOf(
                WelcomeSlide(
                    "We believe in returning to society",
                    "That's why since 2016, we've been a part of programs to educate youth about open source.",
                    R.drawable.welcome_illus_one
                ),
                WelcomeSlide(
                    "Of Course, We have Supporters",
                    "We need help too, and our visions would never haven been met if not for our generous supporters.",
                    R.drawable.welcome_illus_two
                ),
                WelcomeSlide(
                    "Eight Projects",
                    "Not alot, not little either. We’re proud to have projects " +
                            "addressing concerns in today's society, from democratic " +
                            "elections to global warming we " +
                            "got it covered.",
                    R.drawable.welcome_illus_three
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        bt_welcome.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, SignInActivity::class.java))
        }

        slider_content.adapter = welcomeSlideAdapter

        //set the indicators
        setupIndicators()
        setCurrentIndicator(0)
        slider_content.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //if it is last intro content show get started button or else show indicators
                setCurrentIndicator(position)
            }
        })
    }

    //set indicators
    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(welcomeSlideAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8,0,8,0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicator_container.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicator_container.childCount
        for (i in 0 until childCount) {
            val imageView = indicator_container[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
