package com.flexicondev.weather

import io.kotlintest.shouldNotBe
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class WeatherBuildPluginTest {
    private lateinit var plugin: WeatherBuildPlugin
    private lateinit var project: Project

    @BeforeAll
    fun before() {
        project = ProjectBuilder.builder().build()
        plugin = WeatherBuildPlugin()
        plugin.apply(project)
    }

    @Test
    fun testWeatherTaskRegistered() {
        project.tasks.findByName("weather") shouldNotBe null
    }
}
