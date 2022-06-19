package com.flexicondev.weather.usecases

import com.flexicondev.weather.network.IPApi
import com.flexicondev.weather.network.WeatherApi

class WeatherService(
    private val ipApi: IPApi,
    private val weatherApi: WeatherApi
) {

    suspend fun getForecast(): String {
        val ipData = ipApi.getIPData()
        val weatherData = weatherApi.getForecast(ipData.latitude, ipData.longitude)

        return "It is $weatherData today."
    }
}
