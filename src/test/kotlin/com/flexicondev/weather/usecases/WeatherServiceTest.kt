package com.flexicondev.weather.usecases

import com.flexicondev.weather.network.IPApi
import com.flexicondev.weather.network.WeatherApi
import com.flexicondev.weather.network.response.IPDataResponse
import com.flexicondev.weather.network.response.WeatherDataResponse
import io.kotlintest.shouldBe
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

internal class WeatherServiceTest {

    private lateinit var ipApiMock: IPApi

    private lateinit var weatherApiMock: WeatherApi

    private lateinit var service: WeatherService

    @BeforeEach
    fun setUp() {
        val ipData = mockedIPData()
        ipApiMock = mock {
            onBlocking { getIPData() } doReturn ipData
        }
        weatherApiMock = mock {
            onBlocking { getForecast(ipData.latitude, ipData.longitude) } doReturn mockedWeatherData()
        }
        service = WeatherService(ipApiMock, weatherApiMock)
    }

    @Test
    fun testGetForecast() = runBlocking {
        service.getForecast() shouldBe "It is 4.5°C 🌦  Freezing Drizzle: Light and dense intensity today."
    }

    private fun mockedIPData(): IPDataResponse =
        IPDataResponse(
            countryCode = "IS",
            city = "Reykjavík",
            ip = "104.28.21.149",
            latitude = 64.1466,
            longitude = 21.9426,
            countryName = "Iceland",
            regionName = "Reykjavík",
            timeZone = "GMT",
            zipCode = "102",
        )

    private fun mockedWeatherData(): WeatherDataResponse =
        WeatherDataResponse(
            latitude = 64.1466,
            longitude = 21.9426,
            current = WeatherDataResponse.WeatherData(
                weatherCode = 56,
                temperature = 4.5,
            ),
        )
}
