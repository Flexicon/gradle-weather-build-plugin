package com.flexicondev.weather.util

/**
 * Interprets the given WMO weather [code] and returns its related weather description.
 *
 * [List of codes](https://open-meteo.com/en/docs).
 *
 * @param code WMO weather code.
 * @return An interpreted weather description.
 */
fun weatherCodeDescription(code: Int): String = when (code) {
    1, 2, 3 -> "Mainly clear, partly cloudy, and overcast"
    45, 48 -> "Fog and depositing rime fog"
    51, 53, 55 -> "Drizzle: Light, moderate, and dense intensity"
    56, 57 -> "Freezing Drizzle: Light and dense intensity"
    61, 63, 65 -> "Rain: Slight, moderate and heavy intensity"
    66, 67 -> "Freezing Rain: Light and heavy intensity"
    71, 73, 75 -> "Snow fall: Slight, moderate, and heavy intensity"
    77 -> "Snow grains"
    80, 81, 82 -> "Rain showers: Slight, moderate, and violent"
    85, 86 -> "Snow showers slight and heavy"
    95 -> "Thunderstorm: Slight or moderate"
    96, 99 -> "Thunderstorm with slight and heavy hail"
    else -> "Clear sky"
}

/**
 * Interprets the given WMO weather [code] and returns its nearest
 * related weather description emoji.
 *
 * @see weatherCodeDescription
 * @param code WMO weather code.
 * @return An interpreted weather description emoji.
 */
fun weatherCodeEmoji(code: Int): String = when (code) {
    0, 1, 2, 3 -> "🌤"
    45, 48 -> "🌥"
    51, 53, 55, 56, 57 -> "🌦"
    61, 63, 65, 66, 67, 80, 81, 82 -> "🌧"
    71, 73, 75, 77, 85, 86 -> "🌨"
    95 -> "🌩"
    96, 99 -> "⛈"
    else -> "🌤"
}