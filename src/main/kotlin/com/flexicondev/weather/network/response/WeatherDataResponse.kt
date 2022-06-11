package com.flexicondev.weather.network.response

import com.flexicondev.weather.domain.weatherCodeDescription
import com.flexicondev.weather.domain.weatherCodeEmoji
import com.google.gson.annotations.SerializedName

data class WeatherDataResponse(

    @field:SerializedName("elevation")
    val elevation: Int,

    @field:SerializedName("latitude")
    val latitude: Double,

    @field:SerializedName("longitude")
    val longitude: Double,

    @field:SerializedName("current_weather")
    val current: WeatherData
) {

    override fun toString(): String = "${temperature()} ${weatherEmoji()}  ${weatherDescription()}"

    private fun temperature(): String = "${current.temperature}°C"

    private fun weatherDescription(): String = current.weatherCode.weatherCodeDescription()

    private fun weatherEmoji(): String = current.weatherCode.weatherCodeEmoji()

    data class WeatherData(

        @field:SerializedName("weathercode")
        val weatherCode: Int,

        @field:SerializedName("winddirection")
        val windDirection: Int,

        @field:SerializedName("windspeed")
        val windSpeed: Double,

        @field:SerializedName("temperature")
        val temperature: Double,

        @field:SerializedName("time")
        val time: String
    )
}
