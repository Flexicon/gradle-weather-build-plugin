package com.flexicondev.weather.network

import com.flexicondev.weather.network.response.IPDataResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IPApi {

    @GET("ip.json")
    suspend fun getIPData(): IPDataResponse

    companion object {
        private const val BASE_URL = "https://tools.nerfthis.xyz"

        fun create(): IPApi =
            Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(IPApi::class.java)
    }
}