package com.reynaldo.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.reynaldo.horoscapp.domain.model.PrediccionModel

data class PredictionResponse(
    @SerializedName("horoscope") val horoscope: String,

    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PrediccionModel? {
        return PrediccionModel(horoscope = horoscope,
            sign =sign)
    }
}