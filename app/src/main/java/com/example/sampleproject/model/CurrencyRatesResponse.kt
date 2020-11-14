package com.example.sampleproject.model


import android.util.ArrayMap
import com.google.gson.annotations.SerializedName

data class CurrencyRatesResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("rates")
    val rates: ArrayMap<String, ArrayMap<String, Double>>,
    @SerializedName("start_at")
    val startAt: String
)