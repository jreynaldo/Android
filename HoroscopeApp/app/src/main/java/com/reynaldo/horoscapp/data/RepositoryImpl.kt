package com.reynaldo.horoscapp.data

import android.util.Log
import com.reynaldo.horoscapp.data.network.HoroscopeApiService
import com.reynaldo.horoscapp.domain.Repository
import com.reynaldo.horoscapp.domain.model.PrediccionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PrediccionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Reynaldo", "Ha ocurrido un error ${it.message}") }
        return null
    }
}