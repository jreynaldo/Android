package com.reynaldo.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.reynaldo.horoscapp.databinding.ItemHoroscopeBinding
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder (view: View):RecyclerView.ViewHolder(view){
 private val binding =ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = binding.tvTitle.context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, newLambda = { onItemSelected(horoscopeInfo)})
        }
    }
  private  fun startRotationAnimation(view: View, newLambda: () ->Unit){
           view.animate().apply {
               duration = 500
               interpolator = LinearInterpolator()
               withEndAction{newLambda()}
               rotationBy(360f)
               start()
           }
    }

}