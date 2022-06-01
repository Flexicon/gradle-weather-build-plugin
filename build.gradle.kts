import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    `java-gradle-plugin`
    `maven-publish`
}

group = "com.flexicondev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.google.code.gson:gson:2.9.0")

    testImplementation(kotlin("test"))
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "com.flexicondev.weather"
            implementationClass = "com.flexicondev.weather.WeatherBuildPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}