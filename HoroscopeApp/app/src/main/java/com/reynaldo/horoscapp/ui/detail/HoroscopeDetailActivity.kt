package com.reynaldo.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.reynaldo.horoscapp.R
import com.reynaldo.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.reynaldo.horoscapp.domain.model.HoroscopeModel
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Aries;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Taurus;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Gemini;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Cancer;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Leo;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Virgo;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Libra;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Scorpio;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Sagittarius;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Capricorn;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Aquarius;
import com.reynaldo.horoscapp.domain.model.HoroscopeModel.Pisces;
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()

    }

    private fun initListeners() {

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()

                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
        var image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_sagittarius
            Sagittarius -> R.drawable.detail_scorpio
            Capricorn -> R.drawable.detail_cancer
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)

    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }
}