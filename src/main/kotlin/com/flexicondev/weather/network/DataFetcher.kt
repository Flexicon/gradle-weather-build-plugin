package com.flexicondev.weather.network

import com.flexicondev.weather.network.response.IPDataResponse
import com.flexicondev.weather.network.response.WeatherDataResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

internal object DataFetcher {
    fun fetchAndPrintWeather() {
        println("Weather 🌦")

        val ipData = when (val result = fetchIPData()) {
            is ApiResult.Success -> result.value
            is ApiResult.Error -> throw (result.cause ?: Exception(result.message))
        }

        val weatherData = when (val result = fetchWeatherData(ipData.latitude, ipData.longitude)) {
            is ApiResult.Success -> result.value
            is ApiResult.Error -> throw (result.cause ?: Exception(result.message))
        }

        println("$weatherData")
    }

    private fun fetchIPData(): ApiResult<IPDataResponse> {
        val request = Request.Builder()
            .url("https://tools.nerfthis.xyz/ip.json")
            .build()

        val response = OkHttpClient().newCall(request).execute()
        if (!response.isSuccessful) return ApiResult.Error("Unexpected response code $response")

        val body = response.body?.string() ?: return ApiResult.Error("Response body is empty $response")
        val ipData = Gson().fromJson(body, IPDataResponse::class.java)

        return ApiResult.Success(ipData)
    }

    private fun fetchWeatherData(latitude: Double, longitude: Double): ApiResult<WeatherDataResponse> {
        val request = Request.Builder()
            .url("https://api.open-meteo.com/v1/forecast?latitude=$latitude&longitude=$longitude&current_weather=true")
            .build()

        val response = OkHttpClient().newCall(request).execute()
        if (!response.isSuccessful) return ApiResult.Error("Unexpected response code $response")

        val body = response.body?.string() ?: return ApiResult.Error("Response body is empty $response")
        val weatherData = Gson().fromJson(body, WeatherDataResponse::class.java)

        return ApiResult.Success(weatherData)
    }
}
