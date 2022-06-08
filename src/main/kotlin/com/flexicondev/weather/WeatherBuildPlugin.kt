package com.flexicondev.weather

import com.flexicondev.weather.network.IPApi
import com.flexicondev.weather.network.WeatherApi
import kotlinx.coroutines.runBlocking
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherBuildPlugin : Plugin<Project> {
    private val ipApi = IPApi.create()

    private val weatherApi = WeatherApi.create()

    override fun apply(target: Project) {
        target.tasks.findByName("build").apply {
            this?.doLast { runBlocking { fetchAndPrintWeather() } }
        }
    }

    private suspend fun fetchAndPrintWeather() {
        println("Weather 🌦")

        val ipData = ipApi.getIPData()
        val weatherData = weatherApi.getForecast(ipData.latitude, ipData.longitude)

        println("$weatherData")
    }
}
