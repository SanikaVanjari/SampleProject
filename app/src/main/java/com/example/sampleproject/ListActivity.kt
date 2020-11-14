package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleproject.model.CurrencyRatesResponse
import com.example.sampleproject.network.ApiCall
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SampleProject)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        getDataFromApi()
    }

    private fun getDataFromApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.exchangeratesapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ApiCall = retrofit.create(ApiCall::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<CurrencyRatesResponse>{
            override fun onResponse(
                call: Call<CurrencyRatesResponse>,
                response: Response<CurrencyRatesResponse>
            ) {
                var message = response.body()?.rates.toString()
                Log.d("dataResponse", message)
                setData(response.body()?.rates)
            }

            override fun onFailure(call: Call<CurrencyRatesResponse>, t: Throwable) {
                Log.d("dataResponseError", t.toString())
            }

        })
    }

    private fun setData(data: ArrayMap<String, ArrayMap<String, Double>>?) {
        currencyMainRV.apply {
            layoutManager= LinearLayoutManager(this@ListActivity,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
            adapter = CurrencyMainAdapter(data)
        }

    }
}