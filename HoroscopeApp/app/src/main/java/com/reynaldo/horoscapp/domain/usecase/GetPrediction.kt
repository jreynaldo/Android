package com.reynaldo.horoscapp.domain.usecase

import com.reynaldo.horoscapp.domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sing: String) = repository.getPrediction(sing)

}