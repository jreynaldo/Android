package com.reynaldo.horoscapp.data.provider

import com.reynaldo.horoscapp.domain.model.HoroscopeInfo
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Aries
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Leo
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Virgo
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Libra
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo.Pisces
import javax.inject.Inject


class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo>{
        return listOf(
            Aries,
            Taurus,
                    Gemini,
                    Cancer,
                    Leo,
                    Virgo,
                    Libra,
                    Scorpio,
                    Sagittarius,
                    Capricorn,
                    Aquarius,
                    Pisces,
        )
    }
}