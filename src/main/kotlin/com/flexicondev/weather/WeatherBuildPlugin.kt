package com.flexicondev.weather

import com.flexicondev.weather.network.IPApi
import com.flexicondev.weather.network.WeatherApi
import com.flexicondev.weather.usecases.ForecastFetcher
import kotlinx.coroutines.runBlocking
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherBuildPlugin : Plugin<Project> {
    private val ipApi = IPApi.create()

    private val weatherApi = WeatherApi.create()

    override fun apply(target: Project) {
        target.tasks.register("weather") {
            it.group = "weather"
            it.description = "Check local weather based on your IP geolocation"

            it.doLast { runMainAction(target) }
        }

        target.tasks.findByName("build")?.let {
            it.doLast { runMainAction(target) }
        }
    }

    private fun runMainAction(target: Project) = runBlocking {
        with(target.logger) {
            try {
                quiet(fetchWeatherForecast())
            } catch (e: Exception) {
                warn("No weather data to display. See debug log for more information.")
                debug("Failed to print weather data: $e")
            }
        }
    }

    private suspend fun fetchWeatherForecast(): String =
        ForecastFetcher(ipApi, weatherApi).fetchForecast()
}
