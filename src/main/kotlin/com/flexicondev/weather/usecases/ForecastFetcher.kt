package com.flexicondev.weather.usecases

import com.flexicondev.weather.domain.Weather
import com.flexicondev.weather.network.IPApi
import com.flexicondev.weather.network.WeatherApi

class ForecastFetcher(
    private val ipApi: IPApi,
    private val weatherApi: WeatherApi
) {

    suspend fun fetchForecast(): String = "It is ${fetchCurrentWeather()} today."

    private suspend fun fetchCurrentWeather(): Weather {
        val ipData = ipApi.getIPData()
        val forecast = weatherApi.getForecast(ipData.latitude, ipData.longitude)

        return forecast.toWeather()
    }
}
