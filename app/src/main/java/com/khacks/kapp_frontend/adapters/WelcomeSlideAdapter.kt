package com.khacks.kapp_frontend.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khacks.kapp_frontend.R
import com.khacks.kapp_frontend.dataClass.WelcomeSlide

class WelcomeSlideAdapter(private val welcomeSlides: List<WelcomeSlide>)
  : RecyclerView.Adapter<WelcomeSlideAdapter.IntroSlideViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
    return IntroSlideViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.slider_item_container,
            parent,
            false
        )
    )
  }

  override fun getItemCount(): Int {
    return welcomeSlides.size
  }

  override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
    holder.bind(welcomeSlides[position])
  }

  inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val titleText = view.findViewById<TextView>(R.id.intro_title)
    private val descText = view.findViewById<TextView>(R.id.intro_desc)
    private val illustration = view.findViewById<ImageView>(R.id.intro_image)

    fun bind(welcomeSlide: WelcomeSlide) {
      titleText.text = welcomeSlide.title
      descText.text = welcomeSlide.desc
      illustration.setImageResource(welcomeSlide.icon)
    }
  }

}