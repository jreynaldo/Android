package com.reynaldo.horoscapp.domain

import com.reynaldo.horoscapp.domain.model.PrediccionModel

interface Repository {
    suspend fun getPrediction(sign: String):PrediccionModel?
}