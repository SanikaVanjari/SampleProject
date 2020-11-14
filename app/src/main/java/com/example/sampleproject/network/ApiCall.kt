package com.example.sampleproject.network

import com.example.sampleproject.model.CurrencyRatesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("/history")
    fun getData(
        @Query("start_at") start_at: String,
        @Query("end_at") end_at: String,
        @Query("base") base: String
    ): Call<CurrencyRatesResponse>

    @GET("history?start_at=2018-01-01&end_at=2018-09-01&base=USD")
    fun getData() : Call<CurrencyRatesResponse>
}