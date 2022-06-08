package com.flexicondev.weather.network

import com.flexicondev.weather.network.response.WeatherDataResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast?current_weather=true")
    suspend fun getForecast(
        @Query("latitude")
        latitude: Double,
        @Query("longitude")
        longitude: Double,
    ): WeatherDataResponse

    companion object {
        private const val BASE_URL = "https://api.open-meteo.com/v1/"

        fun create(): WeatherApi =
            Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(WeatherApi::class.java)
    }
}
