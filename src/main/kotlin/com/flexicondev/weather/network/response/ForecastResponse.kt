package com.flexicondev.weather.network.response

import com.flexicondev.weather.domain.Weather
import com.google.gson.annotations.SerializedName

data class ForecastResponse(

    @field:SerializedName("current_weather")
    val current: WeatherData
) {

    data class WeatherData(

        @field:SerializedName("weathercode")
        val weatherCode: Int,

        @field:SerializedName("temperature")
        val temperature: Double
    )

    fun toWeather() = Weather(current.weatherCode, current.temperature)
}
