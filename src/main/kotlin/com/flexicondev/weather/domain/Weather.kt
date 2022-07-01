package com.flexicondev.weather.domain

data class Weather(val weatherCode: Int, val temperature: Double) {
    override fun toString(): String = "${temperature()} ${weatherEmoji()}  ${weatherDescription()}"

    private fun temperature(): String = "$temperature°C"

    private fun weatherDescription(): String = weatherCode.weatherCodeDescription()

    private fun weatherEmoji(): String = weatherCode.weatherCodeEmoji()
}
