package com.flexicondev.weather

import com.flexicondev.weather.network.DataFetcher
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherBuildPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.findByName("build").apply {
            this?.doLast {
                DataFetcher.fetchAndPrintWeather()
            }
        }
    }
}
